package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.Driver;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.Payment;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.representation.Form;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * <pre>
 * GET /RMS/apps/driver/myrequest
 * GET /RMS/apps/driver/myrequest/edit
 * POST /RMS/apps/driver/myrequest/edit
 * GET /RMS/apps/driver/myrequest/payment
 * POST /RMS/apps/driver/myrequest/pay
 * </pre>
 */
@Path("/myrequest")
public class MyRequest extends DriverAppResource {

    private final String requestID;
    private RequestItem requestItem;

    public MyRequest(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri
    ) {
        super(req, resp, uri);

        requestID = getUserId();
        if (requestID == null)
            raiseError("not authenticated");

        httpRequest.setAttribute("logoutAction", getPathFromApp("logout"));
        httpRequest.setAttribute("homePage", getPathFromApp("myrequest"));

    }

    private void fetchRequestObject() {
        try {
            requestItem = getRequestBuilder(
                    service.path("request").path("renew").path(requestID))
                    .accept(MediaType.APPLICATION_XML)
                    .get(RequestItem.class);
        } catch (UniformInterfaceException ex) {
            raiseError("request " + requestID + " is not found");
        }
    }

    private Driver getDriver(RequestItem r) {

        try {

            String regoKey = Driver.genKey(
                    r.getLastName(),
                    r.getFirstName(),
                    r.getRegoNumber());
            return getRequestBuilder(
                    service.path("rego").path(regoKey))
                    .accept(MediaType.APPLICATION_XML)
                    .get(Driver.class);

        } catch (Exception ex) {
            raiseError("driver is not found");
            return null;
        }

    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response showStatus()
            throws IOException, ServletException {

        fetchRequestObject();
        httpRequest.setAttribute("myRequest", requestItem);
        httpRequest.setAttribute("requestBase", getPath(MyRequest.class, null));

        Driver d = getDriver(requestItem);
        httpRequest.setAttribute("myRego", d);

        render("status.jsp");
        return Response.ok().build();

    }

    @GET
    @Path("edit")
    @Produces(MediaType.TEXT_HTML)
    public Response showEditor()
            throws IOException, ServletException {

        fetchRequestObject();
        httpRequest.setAttribute("myRequest", requestItem);
        httpRequest.setAttribute("formAction", getPath(MyRequest.class, "edit"));
        render("edit.jsp");
        return Response.ok().build();

    }

    @POST
    @Path("edit")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(
            @FormParam("first_name") String fname,
            @FormParam("last_name") String lname,
            @FormParam("rego_num") String rego_num,
            @FormParam("license") String license,
            @FormParam("address") String address) throws IOException {

        RequestItem req = new RequestItem(lname, fname, license, rego_num, address);

        ClientResponse response = getRequestBuilder(
                service.path("request").path("renew").path(requestID))
                .accept(MediaType.APPLICATION_XML)
                .type(MediaType.APPLICATION_XML)
                .put(ClientResponse.class, req);

        if (response.getStatus() != 200)
            raiseError(response.getStatus() + ":" + response.getEntity(String.class));

        httpResponse.sendRedirect(getPath(MyRequest.class, null));

    }

    @GET
    @Path("payment")
    @Produces(MediaType.TEXT_HTML)
    public void getPayment() throws ServletException, IOException {

        fetchRequestObject();
        String pid = requestItem.getPaymentId();
        if (pid == null)
            raiseError("You haven't received payment notification.");

        try {

            Payment p = getRequestBuilder(
                    service.path("payment").path("renew").path(pid))
                    .accept(MediaType.APPLICATION_XML)
                    .get(Payment.class);

            httpRequest.setAttribute("formAction", getPath(MyRequest.class, "pay"));
            httpRequest.setAttribute("payment", p);
            render("payment.jsp");

        } catch (UniformInterfaceException ex) {
            raiseError(ex);
        }
    }

    @POST
    @Path("pay")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void pay(
            @FormParam("card") String card) throws IOException {

        fetchRequestObject();
        String pid = requestItem.getPaymentId();
        if (pid == null)
            raiseError("You haven't received payment notification.");

        Form form = new Form();
        form.add("card", card);

        try {

            ClientResponse response = getRequestBuilder(
                    service.path("payment").path("renew").path(pid).path("pay"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .put(ClientResponse.class, form);

            if (response.getStatus() != 200)
                raiseError(response.getEntity(String.class));

            httpResponse.sendRedirect(getPath(MyRequest.class, "payment"));

        } catch (ClientHandlerException ex) {
            raiseError(ex);
        } catch (UniformInterfaceException ex) {
            raiseError(ex);
        }

    }
}

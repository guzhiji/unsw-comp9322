package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.Payment;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import com.sun.jersey.api.client.ClientResponse;
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

/*
 GET /RMS/apps/driver/myrequest
 GET /RMS/apps/driver/myrequest/edit
 POST /RMS/apps/driver/myrequest/edit
 POST /RMS/apps/driver/myrequest/pay
 */
@Path("/myrequest")
public class MyRequest extends DriverAppResource {

    private final String requestID;

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

    private Response getContent(String tpl) throws ServletException, IOException {

        RequestItem r = getRequestBuilder(
                service.path("request").path("renew").path(requestID))
                .accept(MediaType.APPLICATION_XML)
                .get(RequestItem.class);

        httpRequest.setAttribute("myRequest", r);
        render(tpl);

        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response showStatus()
            throws IOException, ServletException {

        httpRequest.setAttribute("requestBase", getPath(MyRequest.class, null));
        return getContent("status.jsp");
    }

    @GET
    @Path("edit")
    @Produces(MediaType.TEXT_HTML)
    public Response showEditor()
            throws IOException, ServletException {

        httpRequest.setAttribute("formAction", getPath(MyRequest.class, "edit"));
        return getContent("edit.jsp");

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

        if (response.getStatus() == 200)
            httpResponse.sendRedirect(getPath(MyRequest.class, null));
        else
            raiseError(response.getStatus() + ":" + response.getEntity(String.class), "status.jsp");

    }

    @GET
    @Path("payment")
    @Produces(MediaType.TEXT_HTML)
    public void getPayment() {
        try {

            RequestItem r = getRequestBuilder(
                    service.path("request").path("renew").path(requestID))
                    .accept(MediaType.APPLICATION_XML)
                    .get(RequestItem.class);

            Payment p = getRequestBuilder(
                    service.path("payment").path("renew").path(r.getPaymentId()))
                    .accept(MediaType.APPLICATION_XML)
                    .get(Payment.class);

            httpRequest.setAttribute("formAction", getPath(MyRequest.class, "pay"));
            httpRequest.setAttribute("payment", p);
            render("payment.jsp");

        } catch (Exception ex) {
            raiseError(ex);
        }
    }

    @POST
    @Path("pay")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response pay(
            @FormParam("card") String card) throws IOException {

        Form form = new Form();
        form.add("card", card);

        ClientResponse response = getRequestBuilder(
                service.path("payment").path("renew").path(requestID).path("pay"))
                .accept(MediaType.APPLICATION_XML)
                .type(MediaType.APPLICATION_FORM_URLENCODED)
                .put(ClientResponse.class, form);

        if (response.getStatus() != 200)
            raiseError(response.getEntity(String.class));

        httpResponse.sendRedirect(getPath(MyRequest.class, "payment"));
        return Response.ok().build();

    }
}

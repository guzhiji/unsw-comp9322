package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipChecker;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipChecker;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.Driver;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.Payment;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.SoapCheckerMessage;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.representation.Form;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * <pre>
 * GET /RMS/apps/officer/request/renew/[id]
 * GET /RMS/apps/officer/request/renew/[id]/payment
 * POST /RMS/apps/officer/request/renew/[id]/review
 * GET /RMS/apps/officer/request/renew/[id]/accept
 * POST /RMS/apps/officer/request/renew/[id]/accept
 * GET /RMS/apps/officer/request/renew/[id]/reject
 * POST /RMS/apps/officer/request/renew/[id]/reject
 * GET /RMS/apps/officer/request/renew/[id]/check
 * POST /RMS/apps/officer/request/renew/[id]/check/invoke
 * </pre>
 */
@Path("/request/renew/{id}")
public class RenewalRequest extends OfficerAppResource {

    private final String id;

    public RenewalRequest(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri,
            @PathParam("id") String rid) {
        super(req, resp, uri);

        if (getUserId() == null)
            raiseError("not authenticated");

        id = rid;
        httpRequest.setAttribute("homePage", getPathFromApp("request/list/NEW"));
        httpRequest.setAttribute("formActionBase", getPathFromApp("request/renew/" + id));
        httpRequest.setAttribute("logoutAction", getPathFromApp("logout"));

    }

    private RequestItem getRequestItem(String requestID) {

        try {
            return getRequestBuilder(
                    service.path("request").path("renew").path(requestID))
                    .accept(MediaType.APPLICATION_XML)
                    .get(RequestItem.class);
        } catch (UniformInterfaceException ex) {
            raiseError("request " + requestID + " is not found");
            return null;
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
    public void display() throws IOException, ServletException {

        RequestItem r = getRequestItem(id);
        Driver d = getDriver(r);
        httpRequest.setAttribute("requestDetail", r);
        httpRequest.setAttribute("regoDetail", d);
        render("detail.jsp");

    }

    @GET
    @Path("payment")
    @Produces(MediaType.TEXT_HTML)
    public void getPayment() {

        RequestItem r = getRequestItem(id);

        try {

            Payment p = getRequestBuilder(
                    service.path("payment").path("renew").path(r.getPaymentId()))
                    .accept(MediaType.APPLICATION_XML)
                    .get(Payment.class);

            httpRequest.setAttribute("payment", p);
            render("payment.jsp");

        } catch (Exception ex) {
            raiseError(ex);
        }
    }

    @POST
    @Path("review")
    @Produces(MediaType.TEXT_HTML)
    public void review() throws IOException {
        try {

            ClientResponse r = getRequestBuilder(
                    service.path("request").path("renew").path(id).path("review"))
                    .accept(MediaType.APPLICATION_XML)
                    .put(ClientResponse.class);

            if (r.getStatus() != 200)
                raiseError("Status was not successfully changed to UNDER-REVIEW." + r.getEntity(String.class));

            httpResponse.sendRedirect(getPathFromApp("request/renew/" + id));

        } catch (UniformInterfaceException ex) {
            raiseError(ex);
        }
    }

    @GET
    @Path("accept")
    @Produces(MediaType.TEXT_HTML)
    public void showAcceptForm() throws ServletException, IOException {
        render("accept.jsp");
    }

    @POST
    @Path("accept")
    @Produces(MediaType.TEXT_HTML)
    public void accept(@FormParam("fee") String fee) {

        try {
            ClientResponse r;

            Form form = new Form();
            form.add("request", id);
            form.add("amount", fee);

            r = getRequestBuilder(
                    service.path("payment").path("create"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .post(ClientResponse.class, form);

            if (r.getStatus() != 201)
                raiseError(r.getEntity(String.class), "accept.jsp");

            String pid = r.getLocation().getPath();
            pid = pid.substring(pid.lastIndexOf('/', pid.length() - 2) + 1);

            form = new Form();
            form.add("payment_id", pid);

            r = getRequestBuilder(
                    service.path("request").path("renew").path(id).path("accept"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .put(ClientResponse.class, form);

            if (r.getStatus() != 200)
                raiseError(r.getEntity(String.class), "accept.jsp");

            httpResponse.sendRedirect(getPathFromApp("request/renew/" + id));

        } catch (Exception ex) {
            raiseError(ex);
        }
    }

    @GET
    @Path("reject")
    @Produces(MediaType.TEXT_HTML)
    public void showRejectForm() throws ServletException, IOException {
        render("reject.jsp");
    }

    @POST
    @Path("reject")
    @Produces(MediaType.TEXT_HTML)
    public void reject(@FormParam("reason") String reason) {

        try {

            Form form = new Form();
            form.add("reason", reason);

            ClientResponse r = getRequestBuilder(
                    service.path("request").path("renew").path(id).path("reject"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .put(ClientResponse.class, form);

            if (r.getStatus() != 200)
                raiseError(r.getEntity(String.class), "reject.jsp");

            httpResponse.sendRedirect(getPathFromApp("request/renew/" + id));

        } catch (Exception ex) {
            raiseError(ex);
        }
    }

    @GET
    @Path("check")
    @Produces(MediaType.TEXT_HTML)
    public void getCheckResult() {

        try {
            ClientResponse r = getRequestBuilder(
                    service.path("check").path("result").path(id))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_XML)
                    .get(ClientResponse.class);

            if (r.getStatus() != 200)
                raiseError(r.getEntity(String.class));

            SoapCheckerMessage msg = r.getEntity(SoapCheckerMessage.class);
            httpRequest.setAttribute("checkResult", msg);
            render("checker.jsp");

        } catch (Exception ex) {

            raiseError(ex.getMessage());

        }

    }

    @POST
    @Path("check/invoke")
    @Produces(MediaType.TEXT_HTML)
    public void check() throws ServletException, IOException {

        SoapCheckerMessage msg = null;
        RequestItem req = getRequestItem(id);
        try {

            msg = new SoapCheckerMessage();
            msg.setId(id);
            msg.setFirstName(req.getFirstName());
            msg.setLastName(req.getLastName());
            msg.setRegoNumber(req.getRegoNumber());

            AbstractSoapChecker checker;
            checker = new GreenSlipChecker();
            checker.check(msg);
            checker = new PinkSlipChecker();
            checker.check(msg);

            msg.setRunDate(new Date());

            ClientResponse r = getRequestBuilder(
                    service.path("check").path("save"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_XML)
                    .post(ClientResponse.class, msg);

            if (r.getStatus() != 201)
                // check result wasn't saved successfully
                raiseError(r.getEntity(String.class));

            String crid = r.getLocation().getPath();
            crid = crid.substring(crid.lastIndexOf('/', crid.length() - 2) + 1);

            req.setAutoCheckResultId(crid);

            Form form = new Form();
            form.add("crid", crid);
            r = getRequestBuilder(
                    service.path("request").path("renew").path(id).path("checkresult"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .put(ClientResponse.class, form);

            if (r.getStatus() != 200)
                raiseError(r.getEntity(String.class));

            httpResponse.sendRedirect(getPathFromApp("request/renew/" + id + "/check"));

        } catch (AbstractSoapChecker.SoapCheckerException ex) {
            if (msg != null) {
                msg.setRunDate(new Date());
                httpRequest.setAttribute("checkResult", msg);
            }
            httpRequest.setAttribute("checkErrors", ex.getExceptions());
            render("checker.jsp");

        } catch (Exception ex) {
            raiseError(ex);
        }
    }
}

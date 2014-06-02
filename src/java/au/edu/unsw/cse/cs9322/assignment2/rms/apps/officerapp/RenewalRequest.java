package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipChecker;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipChecker;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.SoapCheckerMessage;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.representation.Form;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/*
 GET /RMS/apps/officer/request/renew/[id]
 POST /RMS/apps/officer/request/renew/[id]/review
 POST /RMS/apps/officer/request/renew/[id]/accept
 POST /RMS/apps/officer/request/renew/[id]/reject
 GET /RMS/apps/officer/request/renew/[id]/check
 POST /RMS/apps/officer/request/renew/[id]/check/invoke
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
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public void display() throws IOException, ServletException {
        httpRequest.getSession().setAttribute("logoutAction", getPathFromApp("logout"));
        try {

            RequestItem r = getRequestBuilder(
                    service.path("request").path("renew").path(id))
                    .accept(MediaType.APPLICATION_XML)
                    .get(RequestItem.class);
            httpRequest.setAttribute("formActionBase", getPathFromApp("request/renew/" + id));
            httpRequest.setAttribute("requestDetail", r);
            render("detail.jsp");

        } catch (Exception ex) {
            raiseError(ex);
        }
    }

    @POST
    @Path("review")
    @Produces(MediaType.TEXT_HTML)
    public void review() {
        try {
            RequestItem r = getRequestBuilder(
                    service.path("request").path("renew").path(id).path("review"))
                    .accept(MediaType.APPLICATION_XML)
                    .put(RequestItem.class);

            httpRequest.setAttribute("formActionBase", getPathFromApp("request/renew/" + id));
            httpRequest.setAttribute("requestDetail", r);
            render("detail.jsp");

        } catch (Exception ex) {
            raiseError(ex);
        }
    }

    @POST
    @Path("accept")
    @Produces(MediaType.TEXT_HTML)
    public void accept(
            @FormParam("fee") float fee) {
        try {

            Form form = new Form();
            form.add("fee", fee);

            ClientResponse r = getRequestBuilder(
                    service.path("request").path("renew").path(id).path("accept"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .put(ClientResponse.class, form);

            if (r.getStatus() == 200) {
                httpRequest.setAttribute("formActionBase", getPathFromApp("request/renew/" + id));
                httpRequest.setAttribute("requestDetail", r.getEntity(RequestItem.class));
                render("detail.jsp");
//                return Response.ok().build();
            } else {
                raiseError(r.getEntity(String.class), "detail.jsp");
            }

        } catch (Exception ex) {
            raiseError(ex, "detail.jsp");
        }
    }

    @POST
    @Path("reject")
    @Produces(MediaType.TEXT_HTML)
    public void reject(
            @FormParam("reason") String reason) {
        try {

            Form form = new Form();
            form.add("reason", reason);

            ClientResponse r = getRequestBuilder(
                    service.path("request").path("renew").path(id).path("reject"))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .put(ClientResponse.class, form);

            if (r.getStatus() == 200) {
                httpRequest.setAttribute("formActionBase", getPathFromApp("request/renew/" + id));
                httpRequest.setAttribute("requestDetail", r.getEntity(RequestItem.class));
                render("detail.jsp");
            } else {
                raiseError(r.getEntity(String.class));
            }

        } catch (Exception ex) {
            raiseError(ex);
        }
    }

    @GET
    @Path("check")
    @Produces(MediaType.TEXT_HTML)
    public void getCheckResult() {

        try {

            SoapCheckerMessage msg = getRequestBuilder(
                    service.path("check").path("result").path(id))
                    .accept(MediaType.APPLICATION_XML)
                    .type(MediaType.APPLICATION_XML)
                    .get(SoapCheckerMessage.class);

            httpRequest.setAttribute("checkResult", msg);
            render("checker.jsp");

        } catch (Exception ex) {

            raiseError(ex);

        }

    }

    @POST
    @Path("check/invoke")
    @Produces(MediaType.TEXT_HTML)
    public void check() throws ServletException, IOException {

        try {

            RequestItem req = getRequestBuilder(
                    service.path("request").path("renew").path(id))
                    .accept(MediaType.APPLICATION_XML)
                    .get(RequestItem.class);

            SoapCheckerMessage msg = new SoapCheckerMessage();
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

            if (r.getStatus() == 200 || r.getStatus() == 201)
                httpResponse.sendRedirect(getPathFromApp("request/renew/" + id + "/check"));
            else
                raiseError(r.getEntity(String.class));

//            httpRequest.setAttribute("checkResult", msg);
//            render("checker.jsp");
//            return Response.ok().build();
        } catch (AbstractSoapChecker.SoapCheckerException ex) {

            httpRequest.setAttribute("checkErrors", ex.getExceptions());
            render("checker_error.jsp");

        } catch (Exception ex) {
            raiseError(ex);
        }
    }
}

package au.edu.unsw.cse.cs9322.assignment2.rms.rest.request;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.PaymentDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.RMSService;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.payment.RMSPayment;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

/**
 * GET /RMS/rest/request/renew/[id]
 * PUT /RMS/rest/request/renew/[id]
 * DELETE /RMS/rest/request/renew/[id]
 * PUT /RMS/rest/request/renew/[id]/accept
 * PUT /RMS/rest/request/renew/[id]/reject
 * PUT /RMS/rest/request/renew/[id]/review
 *
 * URL pattern: /rest/request/renew/...
 */
@Path("/request/renew/{id}")
public class RenewalRequest extends RMSService {

    RequestItem renewalReq;

    public RenewalRequest(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri,
            @PathParam("id") String id) {

        super(req, resp, uri);

        //checkAppPermission("get");
        try {
            renewalReq = RequestDB.get(id);
        } catch (RequestDB.RequestDBException e) {
            raiseError(404, e.getMessage() + ":" + id);
        }

    }

    /**
     * The details of a renewal request can be retreived anytime through an HTTP
     * GET operation. The repsonse of HTTP GET must contain the latest
     * representation of the renewal request.
     *
     * URL pattern: /rest/request/renew/[id]
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public RequestItem get() {
        return renewalReq;
    }

    /**
     * The details of an existing renewal request can be updated via HTTP PUT.
     * Note: updating is only allowed while the status of the given request
     * remain 'new' (or any equivalent status you decide to represent requests
     * that have not been picked up for processing by RMS Registration Office).
     *
     * URL pattern: /rest/request/renew/[id]
     *
     * @param req
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response update(JAXBElement<RequestItem> req) {
        System.out.println(req.toString());
        //checkAppPermission("update");
        if (renewalReq.getStatus() != RequestStatus.NEW)
            raiseError(401, "No modification can be made after an officer started reviewing the request.");

        try {
            RequestItem nr = req.getValue();
            RequestDB.update(renewalReq.getId(), nr);
            renewalReq = nr;
            return Response.ok().build();
        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

    @PUT
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response update(
            @FormParam("last_name") String lname,
            @FormParam("first_name") String fname,
            @FormParam("license_number") String license,
            @FormParam("rego_number") String rego_num,
            @FormParam("address") String address) {

        //checkAppPermission("update");
        renewalReq.setLastName(lname);
        renewalReq.setFirstName(fname);
        renewalReq.setLicenceNumber(license);
        renewalReq.setRegoNumber(rego_num);
        renewalReq.setAddress(address);

        try {
            RequestDB.update(renewalReq.getId(), renewalReq);
            return Response.ok().build();
        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

    /**
     * After the processing of the request is finalised and if the status is
     * rejected, the renewal request resouce can be archived by HTTP DELETE
     * operation - initiated by Driver Application.
     *
     * URL pattern: /rest/request/renew/[id]
     *
     * @return
     */
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response remove() {

        //checkAppPermission("remove");
        RequestStatus s = renewalReq.getStatus();
        if (s != RequestStatus.NEW
                && s != RequestStatus.ARCHIVED)
            raiseError(401, "The request isn't allowed being removed when being watched.");
        try {
            RequestDB.remove(renewalReq.getId());
            return Response.ok().build();
        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }
    }

    /**
     *
     * URL pattern: /rest/request/renew/[id]/accept
     *
     * @param amount
     * @return
     */
    @PUT
    @Path("accept")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response accept(
            @FormParam("amount") float amount) {

        //checkAppPermission("accept");
        try {

            RequestDB.updateStatus(renewalReq.getId(), RequestStatus.ACCEPTED);
//            PaymentDB.create(renewalReq.getId(), amount);

            URI uri = uriInfo.getBaseUriBuilder()
                    .path(RMSPayment.class)
                    .path(renewalReq.getId())
                    .build();

            return Response.created(uri).build();

        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

    /**
     *
     * URL pattern: /rest/request/renew/[id]/reject
     *
     * @param reason
     * @return
     */
    @PUT
    @Path("reject")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response reject(
            @FormParam("reason") String reason) {

        //checkAppPermission("reject");
        if (reason == null || reason.isEmpty())
            raiseError(400, "please provide a reason");
        try {
            renewalReq.setRejectReason(reason);
            RequestDB.updateStatus(renewalReq.getId(), RequestStatus.ARCHIVED);

            return Response.ok().build();

        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

    /**
     *
     * URL pattern: /rest/request/renew/[id]/review
     *
     * @return
     */
    @PUT
    @Path("review")
    @Produces(MediaType.APPLICATION_XML)
    public Response review() {

        //checkAppPermission("review");
        try {

            RequestDB.updateStatus(renewalReq.getId(), RequestStatus.UNDER_REVIEW);

            return Response.ok(renewalReq).build();

        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

}

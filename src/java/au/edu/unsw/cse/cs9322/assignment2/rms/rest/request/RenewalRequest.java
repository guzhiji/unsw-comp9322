package au.edu.unsw.cse.cs9322.assignment2.rms.rest.request;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.RMSService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
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
 * represents a single identified request.
 *
 * <pre>
 * GET /RMS/rest/request/renew/[id]             read
 * PUT /RMS/rest/request/renew/[id]             update
 * DELETE /RMS/rest/request/renew/[id]          remove
 * PUT /RMS/rest/request/renew/[id]/checkresult set check result id
 * PUT /RMS/rest/request/renew/[id]/accept      accept & set payment id
 * PUT /RMS/rest/request/renew/[id]/reject      reject
 * PUT /RMS/rest/request/renew/[id]/review      review
 * </pre>
 */
@Path("/request/renew/{id}")
public class RenewalRequest extends RMSService {

    private RequestItem renewalReq;

    public RenewalRequest(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri,
            @PathParam("id") String id) {

        super(req, resp, uri);

        checkAppPermission("get");

        try {
            renewalReq = RequestDB.get(id);
        } catch (RequestDB.RequestDBException e) {
            raiseError(404, e.getMessage() + "[" + id + "]");
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

        checkAppPermission("update");

        if (renewalReq.getStatus() != RequestStatus.NEW)
            raiseError(401, "No modification can be made after an officer started reviewing the request.");

        try {
            RequestItem nr = req.getValue();
            // overwrite some attributes that are not allowed to change
            nr.setId(renewalReq.getId());
            nr.setAutoCheckResultId(renewalReq.getAutoCheckResultId());
            nr.setPaymentId(renewalReq.getPaymentId());
            nr.setRejectReason(renewalReq.getRejectReason());
            nr.setStatus(renewalReq.getStatus());
            // save
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

        checkAppPermission("update");

        if (renewalReq.getStatus() != RequestStatus.NEW)
            raiseError(401, "No modification can be made after an officer started reviewing the request.");

        renewalReq.setLastName(lname);
        renewalReq.setFirstName(fname);
        renewalReq.setLicenceNumber(license);
        renewalReq.setRegoNumber(rego_num);
        renewalReq.setAddress(address);

        return Response.ok().build();

        /*
         try {
         RequestDB.update(renewalReq.getId(), renewalReq);
         return Response.ok().build();
         } catch (RequestDB.RequestDBException ex) {
         return raiseError(400, ex.getMessage());
         }
         */
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
    @Produces(MediaType.APPLICATION_XML)
    public Response remove() {

        checkAppPermission("remove");

        RequestStatus s = renewalReq.getStatus();
        if (s != RequestStatus.NEW)
            //&& s != RequestStatus.ARCHIVED)
            raiseError(401, "The request isn't allowed to be removed when being watched by officers.");

        try {
            RequestDB.remove(renewalReq.getId());
            return Response.ok().build();
        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }
    }

    /**
     * set check result id that points to a check result provided by the check
     * result service.
     *
     * PUT /RMS/rest/request/renew/[id]/checkresult
     *
     * @param crid
     * @return
     */
    @PUT
    @Path("checkresult")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response setCheckResult(
            @FormParam("crid") String crid) {

        checkAppPermission("setCheckResult");

        renewalReq.setAutoCheckResultId(crid);
        return Response.ok().build();

        /*
         try {
         RequestDB.update(renewalReq.getId(), renewalReq);
         return Response.ok().build();
         } catch (RequestDB.RequestDBException ex) {
         return raiseError(400, ex.getMessage());
         }
         */
    }

    /**
     * set payment id that points to a payment provided by the payment service;
     * set status of the current request to ACCEPTED.
     *
     * URL pattern: /rest/request/renew/[id]/accept
     *
     * @param pid
     * @return
     */
    @PUT
    @Path("accept")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response accept(
            @FormParam("payment_id") String pid) {

        checkAppPermission("accept");

        String p = renewalReq.getPaymentId();
        renewalReq.setPaymentId(pid);

        try {
            RequestDB.updateStatus(renewalReq.getId(), RequestStatus.ACCEPTED);
            return Response.ok().build();
        } catch (RequestDB.RequestDBException ex) {
            renewalReq.setPaymentId(p);
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

        checkAppPermission("reject");

        if (reason == null || reason.isEmpty())
            raiseError(400, "please provide a reason");
        String breason = renewalReq.getRejectReason();
        renewalReq.setRejectReason(reason);

        try {
            RequestDB.updateStatus(renewalReq.getId(), RequestStatus.ARCHIVED);
            return Response.ok().build();
        } catch (RequestDB.RequestDBException ex) {
            renewalReq.setRejectReason(breason);
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

        checkAppPermission("review");

        try {

            RequestDB.updateStatus(renewalReq.getId(), RequestStatus.UNDER_REVIEW);
            return Response.ok().build();

        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

}

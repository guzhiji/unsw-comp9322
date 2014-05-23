package au.edu.unsw.cse.cs9322.assignment2.rms.rest;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class RenewalRequest {

    UriInfo uriInfo;
    Request request;
    String requestId;
    RequestItem renewalReq;

    public RenewalRequest(UriInfo uriInfo, Request request, String id)
            throws RequestDB.RequestDBException {
        this.uriInfo = uriInfo;
        this.request = request;
        this.requestId = id;
        renewalReq = RequestDB.get(id);
    }

    /**
     * The details of a renewal request can be retreived anytime through an HTTP
     * GET operation. The repsonse of HTTP GET must contain the latest
     * representation of the renewal request.
     *
     * @return
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB.RequestDBException
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public RequestItem get() throws RequestDB.RequestDBException {
        return renewalReq;
    }

    /**
     * The details of an existing renewal request can be updated via HTTP PUT.
     * Note: updating is only allowed while the status of the given request
     * remain 'new' (or any equivalent status you decide to represent requests
     * that have not been picked up for processing by RMS Registration Office).
     *
     * @param req
     * @return
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB.RequestDBException
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response update(JAXBElement<RequestItem> req) throws RequestDB.RequestDBException {

        if (renewalReq.getStatus() == RequestStatus.NEW) {

            RequestItem nr = req.getValue();
            RequestDB.update(requestId, nr);
            renewalReq = nr;
            return Response.ok().build();
        }
        return Response.serverError().build();

    }

    /**
     * After the processing of the request is finalised and if the status is
     * rejected, the renewal request resouce can be archived by HTTP DELETE
     * operation - initiated by Driver Application.
     *
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB.RequestDBException
     */
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response remove()
            throws RequestDB.RequestDBException {

        if (renewalReq.getStatus() == RequestStatus.NEW
                || renewalReq.getStatus() == RequestStatus.ARCHIVED) {
            RequestDB.remove(requestId);
            return Response.ok().build();
        }
        return Response.serverError().build();

    }
}

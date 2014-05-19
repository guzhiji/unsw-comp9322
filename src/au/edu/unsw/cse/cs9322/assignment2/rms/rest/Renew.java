package au.edu.unsw.cse.cs9322.assignment2.rms.rest;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

/*
 * Driver's perspective:
 * /renew/request 
 * /renew/request/xxxx
 * /renew/payment/xxxx
 *
 * RMS Officer's perspective: 
 * /renew/registration 
 * /renew/registration/xxxx
 * 
 * 
 */
@Path("/renew")
public class Renew {

    // Allows to insert contextual objects into the class, 
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    /**
     * A renewal request is created by HTTP POST (initiated by Driver
     * Application). The response of HTTP POST must contain the URI/Location of
     * the new renewal request created by the RESTful service.
     *
     * @param lname
     * @param fname
     * @param license
     * @param rego_num
     * @param address
     * @return
     */
    @POST
    @Path("request")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response request(
            @FormParam("last_name") String lname,
            @FormParam("first_name") String fname,
            @FormParam("license_number") String license,
            @FormParam("rego_number") String rego_num,
            @FormParam("address") String address
    ) {

        RequestDB.Request r = new RequestDB.Request(
                lname, fname, license, rego_num, address);
        RequestDB.add(r);
        return Response.ok(r.getId()).build();

    }

    @POST
    @Path("request")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response request(JAXBElement<RequestDB.Request> req) {

        RequestDB.Request r = req.getValue();
        RequestDB.add(r);
        return Response.ok(r.getId()).build();

    }

    @Path("request/{request}")
    public RenewalRequest getRequest(
            @PathParam("request") String id)
            throws RequestDB.RequestDBException {
        return new RenewalRequest(uriInfo, request, id);
    }

    @Path("payment/{request}")
    public RenewalPayment getPayment(
            @PathParam("request") String id) {
        return new RenewalPayment(uriInfo, request, id);
    }

    @GET
    @Path("registration/requests")
    @Produces(MediaType.APPLICATION_XML)
    public List<RequestDB.Request> getList() {
        List<RequestDB.Request> l = new ArrayList<RequestDB.Request>();
        for (RequestDB.Request r : RequestDB.getQueueList())
            l.add(r);
        return l;
    }

    @Path("registration/request/{request}")
    public Registration getRegistration(
            @PathParam("request") String id) {
        return new Registration(uriInfo, request, id);
    }

}

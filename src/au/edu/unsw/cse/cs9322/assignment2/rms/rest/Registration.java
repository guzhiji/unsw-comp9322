package au.edu.unsw.cse.cs9322.assignment2.rms.rest;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.PaymentDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

public class Registration {

    UriInfo uriInfo;
    Request request;
    String id;

    public Registration(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    /**
     * A new payment resource for the renewal fee is created by HTTP POST -
     * initiated by RMS Registration Officer Application. When a renewal request
     * is accepted by the officer, the RMS Registration Officer Application
     * sends HTTP POST to the relevant RESTful service. In this request, the
     * officer should indicate how much the renewal fee is). The response of
     * this HTTP POST must containa URI of the new payment and its location.
     *
     * @param amount
     * @return
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB.RequestDBException
     */
    @POST
    @Path("accept")
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public PaymentDB.Payment accept(
            JAXBElement<Float> amount)
            throws RequestDB.RequestDBException {

        RequestDB.updateStatus(id, RequestDB.Status.ACCEPTED);
        return PaymentDB.create(id, amount.getValue());

    }

    @POST
    @Path("accept")
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public PaymentDB.Payment accept(
            @FormParam("amount") float amount)
            throws RequestDB.RequestDBException {

        RequestDB.updateStatus(id, RequestDB.Status.ACCEPTED);
        return PaymentDB.create(id, amount);

    }

    @PUT
    @Path("reject")
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response reject(JAXBElement<String> reason)
            throws RequestDB.RequestDBException {

        if (reason.isNil()) {
            // TODO exception - please provide a reason
        }

        RequestDB.Request r = RequestDB.get(id);
        r.setRejectReason(reason.getValue());
        RequestDB.updateStatus(id, RequestDB.Status.ARCHIVED);

        return Response.ok(r).build();

    }

    @PUT
    @Path("review")
    @Produces(MediaType.TEXT_XML)
    public Response review()
            throws RequestDB.RequestDBException {

        RequestDB.updateStatus(id, RequestDB.Status.UNDER_REVIEW);

        return Response.ok().build();

    }

}

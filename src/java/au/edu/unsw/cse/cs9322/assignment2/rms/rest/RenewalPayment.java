package au.edu.unsw.cse.cs9322.assignment2.rms.rest;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.PaymentDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public class RenewalPayment {

    UriInfo uriInfo;
    Request request;
    String id;
    PaymentDB.Payment payment;

    public RenewalPayment(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
        payment = PaymentDB.get(id);
    }

    /**
     * A payment can be retrieved by HTTP GET at any time. HTTP GET on a payment
     * should return the latest representatin of the payment resource (including
     * NOT FOUND if it doesn't exist).
     *
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_XML)
    public PaymentDB.Payment get() {

        return payment;

    }

    /**
     * A payment is updated by HTTP PUT - initiated by Driver Application. If
     * the renewal request is accepted, the Driver Application will be given the
     * payment resource created earlier for it to update with the actual payment
     * details.
     *
     * @return
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB.RequestDBException
     */
    @PUT
    @Path("pay")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response pay(
            @FormParam("amount") float amount)
            throws RequestDB.RequestDBException {

        RequestDB.Request r = RequestDB.get(id);
        payment.setPaidDate(new Date());
        RequestDB.updateStatus(id, RequestDB.Status.ARCHIVED);

        return Response.ok(payment).build();
    }

}

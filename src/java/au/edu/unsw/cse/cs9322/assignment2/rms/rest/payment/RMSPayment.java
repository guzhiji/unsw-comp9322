package au.edu.unsw.cse.cs9322.assignment2.rms.rest.payment;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.Payment;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.PaymentDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.RMSService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
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

/**
 * GET /RMS/rest/payment/renew/[id]
 * PUT /RMS/rest/payment/renew/[id]/pay
*/
@Path("/payment/renew/{id}")
public class RMSPayment extends RMSService {

    Payment payment;

    public RMSPayment(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri,
            @PathParam("id") String id) {
        super(req, resp, uri);

        //checkAppPermission("get");
        try {
            payment = PaymentDB.get(id);
        } catch (PaymentDB.PaymentDBException ex) {
            raiseError(404, ex.getMessage());
        }
    }

    /**
     * A payment can be retrieved by HTTP GET at any time. HTTP GET on a payment
     * should return the latest representatin of the payment resource (including
     * NOT FOUND if it doesn't exist).
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Payment get() {

        return payment;

    }

    /**
     * A payment is updated by HTTP PUT - initiated by Driver Application. If
     * the renewal request is accepted, the Driver Application will be given the
     * payment resource created earlier for it to update with the actual payment
     * details.
     *
     * @param card
     * @return
     */
    @PUT
    @Path("pay")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    public Response pay(
            @FormParam("card") String card) {

        //checkAppPermission("pay");
        try {
            payment.setPaidDate(new Date());
            payment.setCardNumber(card);
            RequestDB.updateStatus(payment.getId(), RequestStatus.ARCHIVED);

            return Response.ok().build();
        } catch (RequestDB.RequestDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

}

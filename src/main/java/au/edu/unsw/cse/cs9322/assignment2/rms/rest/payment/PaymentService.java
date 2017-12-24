package au.edu.unsw.cse.cs9322.assignment2.rms.rest.payment;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.PaymentDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.RMSService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * <pre>
 * POST /RMS/rest/payment/create
 * </pre>
 */
@Path("/payment")
public class PaymentService extends RMSService {

    public PaymentService(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri) {
        super(req, resp, uri);
    }

    /**
     * A new payment resource for the renewal fee is created by HTTP POST -
     * initiated by RMS Registration Officer Application. When a renewal request
     * is accepted by the officer, the RMS Registration Officer Application
     * sends HTTP POST to the relevant RESTful service. In this request, the
     * officer should indicate how much the renewal fee is). The response of
     * this HTTP POST must contain a URI of the new payment and its location.
     *
     * @param rid
     * @param amount
     * @return
     */
    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(
            @FormParam("request") String rid,
            @FormParam("amount") String amount) {

        checkAppPermission("create");

        if (rid == null || rid.isEmpty())
            return raiseError(400, "Request id is not provided.");

        float fee;
        try {
            fee = Float.parseFloat(amount);
            if (fee <= 0)
                throw new Exception();
        } catch (Exception ex) {
            return raiseError(400, "Please enter a valid fee.");
        }

        try {
            PaymentDB.create(rid, fee);

            URI uri = uriInfo.getBaseUriBuilder()
                    .path(RMSPayment.class)
                    .build(rid);

            return Response.created(uri).build();

        } catch (PaymentDB.PaymentDBException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

}

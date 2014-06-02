package au.edu.unsw.cse.cs9322.assignment2.rms.rest.checkresult;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.SoapCheckerMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.CheckResultDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.CheckResultDB.CheckResultDBException;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.RMSService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

/**
 * <pre>
 * POST /RMS/rest/check/save
 * GET /RMS/rest/check/result/[id]
 * </pre>
 */
@Path("/check")
public class CheckResult extends RMSService {

    public CheckResult(
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
     * @param result
     * @return
     */
    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response save(JAXBElement<SoapCheckerMessage> result) {

        //checkAppPermission("save");
        try {
            SoapCheckerMessage msg = result.getValue();
            CheckResultDB.create(msg);

            URI uri = uriInfo.getBaseUriBuilder()
                    .path(CheckResult.class)
                    .build(msg.getId());

            return Response.created(uri).build();

        } catch (Exception ex) {
            return raiseError(400, ex.getMessage());
        }

    }

    @GET
    @Path("result/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public SoapCheckerMessage get(@PathParam("id") String id) {

        //checkAppPermission("get");
        try {
            return CheckResultDB.get(id);
        } catch (CheckResultDBException ex) {
            raiseError(404, ex.getMessage());
        } catch (Exception ex) {
            raiseError(400, ex.getMessage());
        }
        return null;
    }

}

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
import javax.ws.rs.core.UriBuilderException;
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

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response save(JAXBElement<SoapCheckerMessage> result) {

        checkAppPermission("save");

        try {
            SoapCheckerMessage msg = result.getValue();
            CheckResultDB.create(msg);

            URI uri = uriInfo.getBaseUriBuilder()
                    .path(CheckResult.class)
                    .path("result")
                    .path(msg.getId())
                    .build();

            return Response.created(uri).build();

        } catch (CheckResultDBException ex) {
            return raiseError(400, ex.getMessage());
        } catch (IllegalArgumentException ex) {
            return raiseError(400, ex.getMessage());
        } catch (UriBuilderException ex) {
            return raiseError(400, ex.getMessage());
        }

    }

    @GET
    @Path("result/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public SoapCheckerMessage get(@PathParam("id") String id) {

        checkAppPermission("get");

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

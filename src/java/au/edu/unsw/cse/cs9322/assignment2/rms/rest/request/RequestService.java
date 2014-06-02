package au.edu.unsw.cse.cs9322.assignment2.rms.rest.request;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestList;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.RMSService;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

/**
 * root of the request service.
 *
 * <pre>
 * POST /RMS/rest/request/renew
 * GET /RMS/rest/request/list
 *
 * URL pattern: /rest/request/...
 * - list:          list requests
 * - renew/[id]:    get the request of type 'renew' and id [id]
 * </pre>
 */
@Path("/request")
public class RequestService extends RMSService {

    public RequestService(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri) {
        super(req, resp, uri);
    }

    /**
     * A renewal request is created by HTTP POST (initiated by Driver
     * Application). The response of HTTP POST must contain the URI/Location of
     * the new renewal request created by the RESTful service.
     *
     * URL pattern: /rest/request/renew
     *
     * @param lname
     * @param fname
     * @param license
     * @param rego_num
     * @param address
     * @return
     */
    @POST
    @Path("renew")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response create(
            @FormParam("last_name") String lname,
            @FormParam("first_name") String fname,
            @FormParam("license_number") String license,
            @FormParam("rego_number") String rego_num,
            @FormParam("address") String address) {

        //checkAppPermission("create");
        RequestItem r = new RequestItem(
                lname, fname, license, rego_num, address);
        RequestDB.add(r);

        URI uri = uriInfo.getBaseUriBuilder()
                .path(RenewalRequest.class) // TODO url will be adjusted
                .build(r.getId());

        return Response.created(uri).build();

    }

    @POST
    @Path("renew")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(JAXBElement<RequestItem> req) {

        //checkAppPermission("create");
        RequestItem r = req.getValue();
        RequestDB.add(r);

        URI uri = uriInfo.getBaseUriBuilder()
                .path(RenewalRequest.class)// TODO url will be adjusted
                .build(r.getId());

        return Response.created(uri).build();

    }

    /**
     *
     * URL pattern: /rest/request/list
     *
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_XML)
    public RequestList getList() {
        //checkAppPermission("list");
        return RequestDB.getList();
    }

}

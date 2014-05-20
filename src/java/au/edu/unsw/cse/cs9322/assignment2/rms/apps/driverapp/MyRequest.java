package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.RequestDB;
import com.sun.jersey.api.client.ClientResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MyRequest extends DriverAppResource {

    private String requestID;

    MyRequest(String rid) {
        requestID = rid;
    }

    @PUT
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(
            @FormParam("first_name") String fname,
            @FormParam("last_name") String lname,
            @FormParam("rego_num") String rego_num,
            @FormParam("license") String license,
            @FormParam("address") String address,
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, ServletException {

        RequestDB.Request r = new RequestDB.Request(lname, fname, license, rego_num, address);

        ClientResponse response = getRequestBuilder(service.path("request").path(requestID))
                .accept(MediaType.APPLICATION_XML)
                .put(ClientResponse.class, r);

        System.out.println(response.getStatus());

        render(req, res, "done.jsp");

    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public void showStatus(
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, ServletException {
        RequestDB.Request r = getRequestBuilder(service.path("request").path(requestID))
                .accept(MediaType.APPLICATION_XML)
                .get(RequestDB.Request.class);
        req.setAttribute("myRequest", r);
        render(req, res, "status.jsp");
    }

    public Response pay() {

        return Response.noContent().build();
    }
}

package au.edu.unsw.cse.cs9322.assignment2.rms.rest.registration;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.Driver;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.DriverDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.rest.RMSService;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/rego/{fname}_{lname}_{regonum}")
public class Rego extends RMSService {

    private Driver driver;

    public Rego(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri,
            @PathParam("fname") String fname,
            @PathParam("lname") String lname,
            @PathParam("regonum") String regonum) {
        super(req, resp, uri);

        checkAppPermission("get");
        try {
            driver = DriverDB.find(lname, fname, regonum);
        } catch (DriverDB.DriverDBException ex) {
            raiseError(404, ex.getMessage());
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Driver get() {

        return driver;

    }

    @PUT
    public Response renew() {

        checkAppPermission("renew");
        driver.setLastRegoDate(new Date());
        return Response.ok().build();

    }

}

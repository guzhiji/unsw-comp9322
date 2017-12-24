package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.Driver;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserIdDB;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserIdDB.UserIdDBException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.representation.Form;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * <pre>
 * GET /RMS/apps/driver/
 * GET /RMS/apps/driver/login
 * GET /RMS/apps/driver/login/[id]
 * POST /RMS/apps/driver/login
 * POST /RMS/apps/driver/logout
 * GET /RMS/apps/driver/request
 * POST /RMS/apps/driver/request
 * </pre>
 */
@Path("/")
public class DriverHome extends DriverAppResource {

    public DriverHome(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri) {
        super(req, resp, uri);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public void show() throws IOException, ServletException {
        httpRequest.setAttribute("formAction", getPathFromApp("login"));
        httpRequest.setAttribute("requestForm", getPathFromApp("request"));
        render("login.jsp");
    }

    @GET
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public void showLoginForm() throws IOException, ServletException {
        show();
    }

    @GET
    @Path("login/{id}")
    @Produces(MediaType.TEXT_HTML)
    public void login(@PathParam("id") String id)
            throws IOException, ServletException {

        // validate id
        ClientResponse r = getRequestBuilder(
                service.path("request").path("renew").path(id))
                .accept(MediaType.APPLICATION_XML)
                .get(ClientResponse.class);

        if (r.getStatus() == 200) {
            setUserId(id);
            httpResponse.sendRedirect(getPathFromApp("myrequest"));
        } else {
            setUserId(null);
            httpResponse.sendRedirect(getPathFromApp("login"));
        }

    }

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void login(
            @FormParam("first_name") String fname,
            @FormParam("last_name") String lname,
            @FormParam("rego_num") String rego_num,
            @FormParam("password") String password)
            throws IOException, ServletException {

        httpRequest.setAttribute("formAction", getPathFromApp("login"));
        httpRequest.setAttribute("requestForm", getPathFromApp("request"));

        try {
            String id = USER_ID_DB.getUserId(fname, lname, rego_num, password);

            if (id != null) {
                setUserId(id);
                httpResponse.sendRedirect(getPathFromApp("myrequest"));
            } else {
                raiseError("Password may be wrong for the user.", "login.jsp");
            }
        } catch (UserIdDB.UserIdDBException ex) {
            raiseError(ex, "login.jsp");
        }

    }

    @POST
    @Path("logout")
    public void logout() throws IOException {

        HttpSession sess = httpRequest.getSession(false);
        if (sess != null) {
            setUserId(null);
            sess.invalidate();
        }
        httpResponse.sendRedirect(getPathFromApp(null));

    }

    @GET
    @Path("request")
    @Produces(MediaType.TEXT_HTML)
    public void showRequestForm() throws IOException, ServletException {

        httpRequest.setAttribute("formAction", getPathFromApp("request"));
        httpRequest.setAttribute("homePage", getPathFromApp(null));

        String id = getUserId();
        if (id != null)
            httpResponse.sendRedirect(getPathFromApp("myrequest"));
        else
            render("form.jsp");

    }

    @POST
    @Path("request")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void request(
            @FormParam("first_name") String fname,
            @FormParam("last_name") String lname,
            @FormParam("password") String password,
            @FormParam("rego_num") String rego_num,
            @FormParam("license") String license,
            @FormParam("address") String address
    ) throws IOException, ServletException {

        try {

            USER_ID_DB.checkUserInfo(fname, lname, rego_num, password);

            try {

                String regoKey = Driver.genKey(
                        lname,
                        fname,
                        rego_num);
                getRequestBuilder(
                        service.path("rego").path(regoKey))
                        .accept(MediaType.APPLICATION_XML)
                        .get(Driver.class);

            } catch (UniformInterfaceException ex) {
                raiseError("The driver is not registered with RMS.");
            }

            Form form = new Form();
            form.add("first_name", fname);
            form.add("last_name", lname);
            form.add("license_number", license);
            form.add("rego_number", rego_num);
            form.add("address", address);

            ClientResponse response = getRequestBuilder(
                    service.path("request").path("renew"))
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .post(ClientResponse.class, form);

            if (response.getStatus() == 201) {

                String id = response.getLocation().getPath();
                id = id.substring(id.lastIndexOf('/', id.length() - 2) + 1);

                USER_ID_DB.register(fname, lname, rego_num, password, id);
                setUserId(id);
                httpResponse.sendRedirect(getPathFromApp("myrequest"));

            } else
                raiseError("service error:" + response.getStatus());

        } catch (UserIdDBException dbex) {
            httpRequest.setAttribute("homePage", getPathFromApp(null));
            raiseError(dbex, "form.jsp");
        }

    }

}

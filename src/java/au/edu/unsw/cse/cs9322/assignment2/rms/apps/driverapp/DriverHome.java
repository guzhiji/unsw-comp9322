package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserDB.UserDBException;
import com.sun.jersey.api.client.ClientResponse;
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
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/")
public class DriverHome extends DriverAppResource {

    @Context
    UriInfo uriInfo;

    private String getPath(String p) {
        UriBuilder b = uriInfo.getBaseUriBuilder().
                path(DriverHome.class);
        if (p == null)
            return b.build().getPath();
        return b.path(p).build().getPath();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public void show(
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, ServletException {
        req.setAttribute("formAction", getPath("login"));
        render(req, res, "login.jsp");
    }

    @GET
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public void showLogin(
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, ServletException {
        show(req, res);
    }

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void login(
            @FormParam("first_name") String fname,
            @FormParam("last_name") String lname,
            @FormParam("rego_num") String rego_num,
            @FormParam("password") String password,
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, DriverAppException, ServletException {

        try {

            String id = USER_DB.getUserId(genKey(fname, lname, rego_num), password);

            if (id != null) {
                setUserId(req, id);
                res.sendRedirect(getPath("myrequest"));
            } else
                res.sendRedirect(getPath("logout"));

        } catch (UserDBException dbex) {
            req.setAttribute("errorMessage", dbex.getMessage());
            render(req, res, "login.jsp");
        }

    }

    @GET
    @Path("logout")
    public void logout(
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException {

        HttpSession sess = req.getSession(false);
        if (sess != null)
            sess.invalidate();
        res.sendRedirect(getPath(null));

    }

    @Path("myrequest")
    public MyRequest getMyRequest(
            @Context HttpServletRequest req)
            throws DriverAppException {

        String id = getUserId(req);
        if (id != null)
            return new MyRequest(id);
        throw new DriverAppException("not authorized");

    }

    @GET
    @Path("request")
    @Produces(MediaType.TEXT_HTML)
    public void showRequestForm(
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, ServletException {

        req.setAttribute("formAction", getPath("request"));

        String id = getUserId(req);
        if (id != null)
            res.sendRedirect(getPath("myrequest"));
        else
            render(req, res, "form.jsp");

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
            @FormParam("address") String address,
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, ServletException, DriverAppException {

        try {

            String key = genKey(fname, lname, rego_num);
            USER_DB.checkUserInfo(key, password);

            Form form = new Form();
            form.add("first_name", fname);
            form.add("last_name", lname);
            form.add("license_number", license);
            form.add("rego_number", rego_num);
            form.add("address", address);

            ClientResponse response = getRequestBuilder(service.path("request"))
                    .type(MediaType.APPLICATION_FORM_URLENCODED)
                    .post(ClientResponse.class, form);

            // Return code should be 201 == created resource
            if (response.getStatus() == 201) {
                String id = response.getLocation().getPath();
                id = id.substring(id.lastIndexOf('/'));
                System.out.println("Form response: request id=" + id);
                USER_DB.register(key, password, id);
                setUserId(req, id);
                res.sendRedirect(getPath("myrequest"));
            } else
                throw new DriverAppException("service error:" + response.getStatus() + "," + service.path("request").toString());

        } catch (UserDBException dbex) {
            req.setAttribute("errorMessage", dbex.getMessage());
            render(req, res, "form.jsp");
        }

    }

}

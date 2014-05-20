package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp.DriverHome;
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
public class OfficerHome extends OfficerAppResource {

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
            @FormParam("username") String username,
            @FormParam("password") String password,
            @Context HttpServletRequest req,
            @Context HttpServletResponse res)
            throws IOException, ServletException {

        String id = USER_DB.getUserId(username, password);

        if (id != null) {
            setUserId(req, id);
            res.sendRedirect(getPath("requests"));
        } else
            res.sendRedirect(getPath("logout"));

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

}

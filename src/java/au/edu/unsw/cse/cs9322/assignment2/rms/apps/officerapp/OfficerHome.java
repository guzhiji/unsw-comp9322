package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

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
import javax.ws.rs.core.UriInfo;

@Path("/")
public class OfficerHome extends OfficerAppResource {

    public OfficerHome(
            @Context HttpServletRequest req,
            @Context HttpServletResponse resp,
            @Context UriInfo uri) {
        super(req, resp, uri);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public void show() throws IOException, ServletException {
        render("login.jsp");
    }

    @GET
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public void showLogin() throws IOException, ServletException {
        show();
    }

    @POST
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void login(
            @FormParam("username") String username,
            @FormParam("password") String password
    ) throws IOException, ServletException {

        String id = USER_DB.getUserId(username, password);

        if (id != null) {
            setUserId(httpRequest, id);
            httpResponse.sendRedirect(getPath("requests"));
        } else {
            raiseError("Password may be wrong for the user.", "login.jsp");
        }

    }

    @POST
    @Path("logout")
    public void logout() throws IOException {

        HttpSession sess = httpRequest.getSession(false);
        if (sess != null)
            sess.invalidate();
        httpResponse.sendRedirect(getPath(null));

    }

}

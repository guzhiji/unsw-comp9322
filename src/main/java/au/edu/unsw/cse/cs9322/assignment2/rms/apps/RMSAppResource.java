package au.edu.unsw.cse.cs9322.assignment2.rms.apps;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.DBBackupService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public abstract class RMSAppResource {

    protected WebResource service;
    protected String appName;
    protected String appKey;

    protected HttpServletRequest httpRequest;
    protected HttpServletResponse httpResponse;
    protected UriInfo uriInfo;

    protected RMSAppResource(
            String app_name,
            HttpServletRequest req,
            HttpServletResponse resp,
            UriInfo uri
    ) {

        ResourceBundle res = ResourceBundle.getBundle(
                RMSAppResource.class.getPackage().getName()
                + "." + app_name + ".config");

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        service = client.resource(res.getString("service_uri"));
        appKey = res.getString("app_key");

        appName = app_name;
        httpRequest = req;
        httpResponse = resp;
        uriInfo = uri;

        DBBackupService.checkStarted(httpRequest.getServletContext().getRealPath("/WEB-INF/data"));
    }

    protected WebResource.Builder getRequestBuilder(WebResource res) {
        return res.header("app_key", appKey);
    }

    protected String getPath(Class cls, String p) {
        UriBuilder b = uriInfo.getBaseUriBuilder().path(cls);
        if (p == null)
            return b.build().getPath();
        return b.path(p).build().getPath();
    }

    protected void render(String page)
            throws ServletException, IOException {
        RequestDispatcher rd = httpRequest.getRequestDispatcher(
                "/WEB-INF/" + appName + "/" + page);
        rd.forward(httpRequest, httpResponse);
    }

    protected void raiseError(Throwable t) {
        raiseError(t.getMessage(), "msg.jsp", t);
    }

    protected void raiseError(Throwable t, String page) {
        raiseError(t.getMessage(), page, t);
    }

    protected void raiseError(String msg) {
        raiseError(msg, "msg.jsp", null);
    }

    protected void raiseError(String msg, String page) {
        raiseError(msg, page, null);
    }

    protected void raiseError(String msg, String page, Throwable t) {
        httpRequest.setAttribute("errorMessage", msg);
        try {
            render(page);
        } catch (Exception ex) {
            throw new WebApplicationException(t, Response.status(500)
                    .entity(msg).type(MediaType.TEXT_PLAIN).build());
        }
        throw new WebApplicationException(t, Response.ok()
                .type(MediaType.TEXT_HTML).build());
    }

    protected String getUserId() {
        HttpSession sess = httpRequest.getSession(false);
        if (sess != null)
            return (String) sess.getAttribute(appName + "user_id");
        return null;
    }

    protected void setUserId(String id) {
        HttpSession sess = httpRequest.getSession();
        sess.setAttribute(appName + "user_id", id);
    }
}

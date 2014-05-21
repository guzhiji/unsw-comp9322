package au.edu.unsw.cse.cs9322.assignment2.rms.apps;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public abstract class RMSAppResource {

    protected WebResource service;
    protected String appKey;

    protected HttpServletRequest httpRequest;
    protected HttpServletResponse httpResponse;
    protected UriInfo uriInfo;

    public RMSAppResource(
            String service_uri,
            String app_key,
            HttpServletRequest req,
            HttpServletResponse resp,
            UriInfo uri
    ) {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        appKey = app_key;
        service = client.resource(service_uri);
        httpRequest = req;
        httpResponse = resp;
        uriInfo = uri;
    }

    protected WebResource.Builder getRequestBuilder(WebResource res) {
        return res.header("app_key", appKey);
    }

    protected void render(String page)
            throws ServletException, IOException {
        RequestDispatcher rd = httpRequest.getRequestDispatcher("/WEB-INF/" + appKey + "/" + page);
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

    protected String getUserId(HttpServletRequest req) {
        HttpSession sess = req.getSession(false);
        if (sess != null)
            return (String) sess.getAttribute("user_id");
        return null;
    }

    protected void setUserId(HttpServletRequest req, String id) {
        HttpSession sess = req.getSession();
        sess.setAttribute("user_id", id);
    }
}

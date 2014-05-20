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

public abstract class RMSAppResource {

    protected WebResource service;
    protected String appKey;

    public RMSAppResource(String uri, String app_key) {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        appKey = app_key;
        service = client.resource(uri);

    }

    protected WebResource.Builder getRequestBuilder(WebResource res) {
        return res.header("app_key", appKey);
    }

    protected void render(HttpServletRequest req, HttpServletResponse res, String page)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/" + appKey + "/" + page);
        rd.forward(req, res);
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

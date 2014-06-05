package au.edu.unsw.cse.cs9322.assignment2.rms.rest;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.DBBackupService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public abstract class RMSService {

    protected HttpServletRequest httpRequest;
    protected HttpServletResponse httpResponse;
    protected UriInfo uriInfo;

    protected WebResource service;
    protected String appKey;

    /**
     * app => allowed operations
     */
    protected Map<String, Set<String>> permissions;

    protected RMSService(
            HttpServletRequest req,
            HttpServletResponse resp,
            UriInfo uri) {

        httpRequest = req;
        httpResponse = resp;
        uriInfo = uri;

        // load config for service as app
        ResourceBundle res = ResourceBundle.getBundle(
                RMSService.class.getPackage().getName()
                + ".config");

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        service = client.resource(res.getString("service_uri"));
        appKey = res.getString("app_key");

        // load app permissions on the service
        permissions = new HashMap<String, Set<String>>();
        res = ResourceBundle.getBundle(
                getClass().getPackage().getName()
                + ".permissions");

        Enumeration<String> e = res.getKeys();
        while (e.hasMoreElements()) {
            String app = e.nextElement();
            Set<String> allowed = new HashSet<String>();
            for (String op : res.getString(app).split(" "))
                if (!op.isEmpty())
                    allowed.add(op);
            permissions.put(app, allowed);
        }

        // trigger DB backup service
        DBBackupService.checkStarted(httpRequest.getServletContext().getRealPath("/WEB-INF/data"));
    }

    protected WebResource.Builder getRequestBuilder(WebResource res) {
        return res.header("app_key", appKey);
    }

    protected void checkAppPermission(String op) {
        try {
            String key = httpRequest.getHeader("app_key");
            if (key == null)
                throw new Exception();
            Set<String> allowed = permissions.get(key);
            if (allowed == null || !allowed.contains(op))
                throw new Exception();
        } catch (Exception ex) {
            raiseError(401, "The request isn't from an authorized app.");
        }
    }

    protected Response raiseError(int status, String msg)
            throws WebApplicationException {
        Response r = Response.status(status)
                .entity(msg)
                .type(MediaType.TEXT_PLAIN)
                .build();
        throw new WebApplicationException(r);
    }

    protected Response raiseError(int status, Throwable t)
            throws WebApplicationException {

        return raiseError(status, t.getMessage());

    }

    protected String getPath(String p) {
        UriBuilder b = uriInfo.getBaseUriBuilder().
                path(getClass());
        if (p == null)
            return b.build().getPath();
        return b.path(p).build().getPath();
    }

}

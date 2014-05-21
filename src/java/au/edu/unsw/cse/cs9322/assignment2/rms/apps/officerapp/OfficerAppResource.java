package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.RMSAppResource;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserDB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

abstract class OfficerAppResource extends RMSAppResource {

    protected final static UserDB USER_DB;

    static {
        USER_DB = new UserDB();
        try {
            USER_DB.register("officer1", "officer1", "officer1");
            USER_DB.register("officer2", "officer2", "officer2");
            USER_DB.register("officer3", "officer3", "officer3");
        } catch (UserDB.UserDBException ex) {
        }
    }

    protected String getPath(String p) {
        UriBuilder b = uriInfo.getBaseUriBuilder().
                path(OfficerHome.class);
        if (p == null)
            return b.build().getPath();
        return b.path(p).build().getPath();
    }

    public OfficerAppResource(
            HttpServletRequest req,
            HttpServletResponse resp,
            UriInfo uri
    ) {
        super("http://localhost:8084/RMS/rest/renew/", "officer_app", req, resp, uri);
    }

}

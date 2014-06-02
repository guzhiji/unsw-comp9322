package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.RMSAppResource;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserDB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriInfo;

abstract class DriverAppResource extends RMSAppResource {

    protected final static UserDB USER_DB = new UserDB();

    protected DriverAppResource(
            HttpServletRequest req,
            HttpServletResponse resp,
            UriInfo uri
    ) {
        super("driverapp", req, resp, uri);
    }

    protected String getPathFromApp(String p) {
        return getPath(DriverHome.class, p);
    }

    protected String genKey(
            String firstName,
            String lastName,
            String regoNumber
    ) throws UserDB.UserDBException {

        if (firstName == null || firstName.isEmpty())
            throw new UserDB.UserDBException("first name is missing");
        if (lastName == null || lastName.isEmpty())
            throw new UserDB.UserDBException("last name is missing");
        if (regoNumber == null || regoNumber.isEmpty())
            throw new UserDB.UserDBException("rego number is missing");

        StringBuilder sb = new StringBuilder();
        sb.append(lastName.replace("_", ""));
        sb.append("_");
        sb.append(firstName.replace("_", ""));
        sb.append("_");
        sb.append(regoNumber.replace("_", ""));

        return sb.toString();

    }

}

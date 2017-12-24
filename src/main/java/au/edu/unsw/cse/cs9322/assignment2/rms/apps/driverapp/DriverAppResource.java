package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.RMSAppResource;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.Driver;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.DBBackupService;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserIdDB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriInfo;

abstract class DriverAppResource extends RMSAppResource {

    protected static class DriverIdDB extends UserIdDB {

        private String genKey(
                String firstName,
                String lastName,
                String regoNumber
        ) throws UserIdDB.UserIdDBException {

            if (firstName == null || firstName.isEmpty())
                throw new UserIdDB.UserIdDBException("first name is missing");
            if (lastName == null || lastName.isEmpty())
                throw new UserIdDB.UserIdDBException("last name is missing");
            if (regoNumber == null || regoNumber.isEmpty())
                throw new UserIdDB.UserIdDBException("rego number is missing");

            return Driver.genKey(lastName, firstName, regoNumber);

        }

        public void checkUserInfo(
                String firstName,
                String lastName,
                String regoNumber,
                String password)
                throws UserIdDBException {

            checkUserInfo(
                    genKey(firstName, lastName, regoNumber),
                    password);

        }

        public String getUserId(
                String firstName,
                String lastName,
                String regoNumber,
                String password)
                throws UserIdDBException {

            return getUserId(
                    genKey(firstName, lastName, regoNumber),
                    password);
        }

        public void register(
                String firstName,
                String lastName,
                String regoNumber,
                String password,
                String uid)
                throws UserIdDBException {

            register(
                    genKey(firstName, lastName, regoNumber),
                    password,
                    uid);

        }

        public void unregister(
                String firstName,
                String lastName,
                String regoNumber)
                throws UserIdDBException {

            unregister(genKey(firstName, lastName, regoNumber));

        }

    }
    protected final static DriverIdDB USER_ID_DB;

    static {
        USER_ID_DB = new DriverIdDB();
        DBBackupService.register(USER_ID_DB);
    }

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

}

package au.edu.unsw.cse.cs9322.assignment2.rms.apps.driverapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.RMSAppResource;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserDB;

abstract class DriverAppResource extends RMSAppResource {

    protected final static UserDB USER_DB = new UserDB();

    public static class DriverAppException extends Exception {

        public DriverAppException(String msg) {
            super(msg);
        }

        public DriverAppException(String msg, Throwable t) {
            super(msg, t);
        }
    }

    protected static String genKey(
            String firstName,
            String lastName,
            String regoNumber)
            throws UserDB.UserDBException {

        if (lastName == null || lastName.isEmpty())
            throw new UserDB.UserDBException("last name is missing");
        if (firstName == null || firstName.isEmpty())
            throw new UserDB.UserDBException("first name is missing");
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

    public DriverAppResource() {
        super("http://localhost:8080/RMS/rest/renew/", "driver_app");
    }

}

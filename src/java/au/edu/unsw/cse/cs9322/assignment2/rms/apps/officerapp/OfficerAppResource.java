package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.RMSAppResource;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.UserDB;

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

    public OfficerAppResource() {
        super("http://localhost:8080/RMS/rest/renew/", "officer_app");
    }

}

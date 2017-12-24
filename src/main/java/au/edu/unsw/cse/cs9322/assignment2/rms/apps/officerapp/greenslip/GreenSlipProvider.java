package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.GreenSlipMessage;

public interface GreenSlipProvider {

    GreenSlipMessage check(String fname, String lname, String rego) throws GreenSlipProviderException;

}

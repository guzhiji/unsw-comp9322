package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.PinkSlipMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.VehicleMessage;

public interface PinkSlipProvider {

    PinkSlipMessage check(String fname, String lname, String rego) throws PinkSlipProviderException;

    VehicleMessage getVehicleInfo(String fname, String lname, String rego) throws PinkSlipProviderException;

}

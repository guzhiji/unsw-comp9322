package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.elemonators;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipProvider;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipProviderException;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.elemonators.GreenSlipServicesStub.Driver;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.elemonators.GreenSlipServicesStub.GreenSlipResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.GreenSlipMessage;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

public class ELemonAtorsGreenSlipProvider implements GreenSlipProvider {

    private final GreenSlipServicesStub stub;

    public ELemonAtorsGreenSlipProvider(String url) throws AxisFault {
        stub = new GreenSlipServicesStub(url);
    }

    private Driver getDriver(String fname, String lname, String rego) {

        Driver v = new Driver();
        v.setFirstName(fname);
        v.setLastName(lname);
        v.setRegoNumber(rego);

        return v;
    }

    @Override
    public GreenSlipMessage check(String fname, String lname, String rego) throws GreenSlipProviderException {
        try {
            Driver d = getDriver(fname, lname, rego);
            GreenSlipResponse resp = stub.gSCheck(d);
            GreenSlipMessage gsm = new GreenSlipMessage();
            gsm.setFirstName(resp.getFirstName());
            gsm.setLastName(resp.getLastName());
            gsm.setPaidFlag(resp.getPaidFlag().getValue().equalsIgnoreCase("yes"));
            gsm.setRegoNumber(resp.getRegoNumber());
            return gsm;
        } catch (RemoteException ex) {
            throw new GreenSlipProviderException(getClass().getSimpleName(), ex);
        } catch (GreenSlipFaultException ex) {
            throw new GreenSlipProviderException(getClass().getSimpleName(), ex);
        }

    }

}

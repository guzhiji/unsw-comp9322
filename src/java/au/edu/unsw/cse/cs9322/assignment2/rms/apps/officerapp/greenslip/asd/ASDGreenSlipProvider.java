package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipProvider;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipProviderException;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.Car;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheck;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd.ASDGreenSlipServicesStub.GSCheckResponseE;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.GreenSlipMessage;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

public class ASDGreenSlipProvider implements GreenSlipProvider {

    private final ASDGreenSlipServicesStub stub;

    public ASDGreenSlipProvider(String url) throws AxisFault {
        stub = new ASDGreenSlipServicesStub(url);
    }

    private Car getCar(String fname, String lname, String rego) {

        Car v = new Car();
        v.setFirstname(fname);
        v.setLastname(lname);
        v.setRegoNumber(rego);

        return v;
    }

    @Override
    public GreenSlipMessage check(String fname, String lname, String rego) throws GreenSlipProviderException {

        try {
            GSCheck c = new GSCheck();
            c.setInput_car(getCar(fname, lname, rego));
            GSCheckResponseE resp = stub.gSCheck(c);
            GSCheckResponse msg = resp.get_return();

            GreenSlipMessage gsm = new GreenSlipMessage();
            gsm.setFirstName(fname);
            gsm.setLastName(lname);
            gsm.setPaidFlag(msg.getPaidFlag());
            gsm.setRegoNumber(rego);

            return gsm;
        } catch (RemoteException ex) {
            throw new GreenSlipProviderException(getClass().getSimpleName(), ex);
        } catch (GreenSlipServicesGSCheckFaultExceptionException ex) {
            throw new GreenSlipProviderException(getClass().getSimpleName(), ex);
        }

    }

}

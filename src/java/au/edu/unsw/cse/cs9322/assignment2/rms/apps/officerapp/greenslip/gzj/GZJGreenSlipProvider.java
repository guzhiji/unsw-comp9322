package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipProvider;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.GreenSlipProviderException;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj.GZJGZJGreenSlipProviderStub.DriverDB_DriverQuery;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj.GZJGZJGreenSlipProviderStub.GSCheck;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj.GZJGZJGreenSlipProviderStub.GSCheckResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj.GZJGZJGreenSlipProviderStub.GreenSlipProvider_GSMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.GreenSlipMessage;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

public class GZJGreenSlipProvider implements GreenSlipProvider {

    private final GZJGZJGreenSlipProviderStub stub;

    public GZJGreenSlipProvider(String url) throws AxisFault {
        stub = new GZJGZJGreenSlipProviderStub(url);
    }

    private DriverDB_DriverQuery createDriverQuery(String fname, String lname, String rego) {
        DriverDB_DriverQuery q = new DriverDB_DriverQuery();
        q.setFirstName(fname);
        q.setLastName(lname);
        q.setRegoNumber(rego);
        return q;
    }

    @Override
    public GreenSlipMessage check(String fname, String lname, String rego) throws GreenSlipProviderException {

        try {
            GSCheck c = new GSCheck();
            c.setArgs0(createDriverQuery(fname, lname, rego));
            GSCheckResponse resp = stub.gSCheck(c);
            GreenSlipProvider_GSMessage msg = resp.get_return();

            GreenSlipMessage gsm = new GreenSlipMessage();
            gsm.setFirstName(msg.getFirstName());
            gsm.setLastName(msg.getLastName());
            gsm.setPaidFlag(msg.getPaidFlag());
            gsm.setRegoNumber(msg.getRegoNumber());

            return gsm;
        } catch (GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException ex) {
            throw new GreenSlipProviderException(ex.getMessage());
        } catch (RemoteException ex) {
            throw new GreenSlipProviderException(ex);
        }

    }
}

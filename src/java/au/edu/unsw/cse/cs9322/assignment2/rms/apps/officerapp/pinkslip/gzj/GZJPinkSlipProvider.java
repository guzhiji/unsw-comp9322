package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipProvider;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipProviderException;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.DriverDB_DriverQuery;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.PSCheck;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.PSCheckResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.PinkSlipProvider_PSMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.PinkSlipProvider_VehicleMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.VehicleInfo;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.VehicleInfoResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.PinkSlipMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.VehicleMessage;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

public class GZJPinkSlipProvider implements PinkSlipProvider {

    private final GZJGZJPinkSlipProviderStub stub;

    public GZJPinkSlipProvider(String url) throws AxisFault {

        stub = new GZJGZJPinkSlipProviderStub(url);

    }

    private DriverDB_DriverQuery createDriverQuery(String fname, String lname, String rego) {

        DriverDB_DriverQuery q = new DriverDB_DriverQuery();
        q.setFirstName(fname);
        q.setLastName(lname);
        q.setRegoNumber(rego);
        return q;
    }

    @Override
    public PinkSlipMessage check(String fname, String lname, String rego) throws PinkSlipProviderException {

        try {
            PSCheck c = new PSCheck();
            c.setArgs0(createDriverQuery(fname, lname, rego));

            PSCheckResponse resp = stub.pSCheck(c);
            PinkSlipProvider_PSMessage msg = resp.get_return();

            PinkSlipMessage psm = new PinkSlipMessage();
            psm.setCheckedFlag(msg.getCheckedFlag());
            psm.setFirstName(msg.getFirstName());
            psm.setLastName(msg.getLastName());
            psm.setRegoNumber(msg.getRegoNumber());

            return psm;
        } catch (GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException ex) {
            throw new PinkSlipProviderException(ex.getMessage());
        } catch (RemoteException ex) {
            throw new PinkSlipProviderException(ex);
        }

    }

    @Override
    public VehicleMessage getVehicleInfo(String fname, String lname, String rego) throws PinkSlipProviderException {

        try {
            VehicleInfo info = new VehicleInfo();
            info.setArgs0(createDriverQuery(fname, lname, rego));

            VehicleInfoResponse resp = stub.vehicleInfo(info);
            PinkSlipProvider_VehicleMessage msg = resp.get_return();

            VehicleMessage vm = new VehicleMessage();
            vm.setFirstName(msg.getFirstName());
            vm.setLastName(msg.getLastName());
            vm.setManufacturedDate(msg.getManufacturedDate());
            vm.setRegoNumber(msg.getRegoNumber());
            vm.setVehicleType(msg.getVehicleType());

            return vm;
        } catch (GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException ex) {
            throw new PinkSlipProviderException(ex.getMessage());
        } catch (RemoteException ex) {
            throw new PinkSlipProviderException(ex);
        }
    }
}

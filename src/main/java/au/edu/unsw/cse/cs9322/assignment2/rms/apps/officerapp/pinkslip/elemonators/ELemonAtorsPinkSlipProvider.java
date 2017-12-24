package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipProvider;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipProviderException;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.Driver;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PSCheckResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.VehicleInfoResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.PinkSlipMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.VehicleMessage;
import java.rmi.RemoteException;
import org.apache.axis2.AxisFault;

public class ELemonAtorsPinkSlipProvider implements PinkSlipProvider {

    private final PinkSlipServicesStub stub;

    public ELemonAtorsPinkSlipProvider(String url) throws AxisFault {

        stub = new PinkSlipServicesStub(url);
    }

    private Driver getDriver(String fname, String lname, String rego) {

        Driver v = new Driver();
        v.setFirstName(fname);
        v.setLastName(lname);
        v.setRegoNumber(rego);

        return v;
    }

    @Override
    public PinkSlipMessage check(String fname, String lname, String rego) throws PinkSlipProviderException {

        try {

            PSCheckResponse resp = stub.pSCheck(getDriver(fname, lname, rego));
            PinkSlipMessage psm = new PinkSlipMessage();
            psm.setCheckedFlag(resp.getCheckedFlag().getValue().equalsIgnoreCase("yes"));
            psm.setFirstName(resp.getFirstName());
            psm.setLastName(resp.getLastName());
            psm.setRegoNumber(resp.getRegoNumber());

            return psm;
        } catch (RemoteException ex) {
            throw new PinkSlipProviderException(getClass().getSimpleName(), ex);
        } catch (PinkSlipFaultException ex) {
            throw new PinkSlipProviderException(getClass().getSimpleName(), ex);
        }

    }

    @Override
    public VehicleMessage getVehicleInfo(String fname, String lname, String rego) throws PinkSlipProviderException {

        try {

            VehicleInfoResponse resp = stub.vehicleInfo(getDriver(fname, lname, rego));

            VehicleMessage vm = new VehicleMessage();
            vm.setFirstName(fname);
            vm.setLastName(lname);
            vm.setManufacturedDate(resp.getManufacturedDate().getTime());
            vm.setRegoNumber(rego);
            vm.setVehicleType(resp.getVehicleType().getValue());
            return vm;
        } catch (RemoteException ex) {
            throw new PinkSlipProviderException(getClass().getSimpleName(), ex);
        } catch (PinkSlipFaultException ex) {
            throw new PinkSlipProviderException(getClass().getSimpleName(), ex);
        }

    }

}

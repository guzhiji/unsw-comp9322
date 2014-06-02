package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipProvider;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.PinkSlipProviderException;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.Car;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.PSCheck;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.PSCheckResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.PSCheckResponseE;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.VehicleInfo;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.VehicleInfoResponse;
import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.VehicleInfoResponseE;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.PinkSlipMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.VehicleMessage;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.axis2.AxisFault;

public class ASDPinkSlipProvider implements PinkSlipProvider {

    private final ASDPinkSlipServicesStub stub;

    public ASDPinkSlipProvider(String url) throws AxisFault {

        stub = new ASDPinkSlipServicesStub(url);
    }

    private Car getCar(String fname, String lname, String rego) {

        Car v = new Car();
        v.setFirstname(fname);
        v.setLastname(lname);
        v.setRegoNumber(rego);

        return v;
    }

    @Override
    public PinkSlipMessage check(String fname, String lname, String rego) throws PinkSlipProviderException {

        try {

            PSCheck c = new PSCheck();
            c.setInput_car(getCar(fname, lname, rego));

            PSCheckResponseE resp = stub.pSCheck(c);
            PSCheckResponse msg = resp.get_return();

            PinkSlipMessage psm = new PinkSlipMessage();
            psm.setCheckedFlag(msg.getCheckedFlag());
            psm.setFirstName(fname);
            psm.setLastName(lname);
            psm.setRegoNumber(rego);

            return psm;
        } catch (RemoteException ex) {
            throw new PinkSlipProviderException(ex);
        } catch (PinkSlipServicesPSCheckFaultExceptionException ex) {
            throw new PinkSlipProviderException(ex.getMessage());
        }

    }

    @Override
    public VehicleMessage getVehicleInfo(String fname, String lname, String rego) throws PinkSlipProviderException {

        try {
            VehicleInfo info = new VehicleInfo();
            info.setInput_car(getCar(fname, lname, rego));
            VehicleInfoResponseE resp = stub.vehicleInfo(info);
            VehicleInfoResponse msg = resp.get_return();

            VehicleMessage vm = new VehicleMessage();
            vm.setFirstName(fname);
            vm.setLastName(lname);
            vm.setManufacturedDate(SimpleDateFormat.getInstance().parse(msg.getManufacturedDate()));
            vm.setRegoNumber(rego);
            vm.setVehicleType(msg.getVehicleType());
            return vm;
        } catch (ParseException ex) {
            throw new PinkSlipProviderException(ex.getMessage());
        } catch (RemoteException ex) {
            throw new PinkSlipProviderException(ex);
        } catch (PinkSlipServicesPSCheckFaultExceptionException ex) {
            throw new PinkSlipProviderException(ex.getMessage());
        }

    }

}

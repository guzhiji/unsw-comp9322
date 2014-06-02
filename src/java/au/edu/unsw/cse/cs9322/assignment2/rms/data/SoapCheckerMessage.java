package au.edu.unsw.cse.cs9322.assignment2.rms.data;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SoapCheckerMessage {

    private String id;

    private Date runDate;
    private String firstName;
    private String lastName;
    private String regoNumber;

    private GreenSlipMessage greenSlip;
    private VehicleMessage vehicleInfo;
    private PinkSlipMessage pinkSlip;
    private boolean pinkSlipRequired;

    public String getId() {
        return id;
    }

    public void setId(String rid) {
        id = rid;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date d) {
        runDate = d;
    }

    public boolean isFinished() {
        return runDate != null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fname) {
        firstName = fname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lname) {
        lastName = lname;
    }

    public String getRegoNumber() {
        return regoNumber;
    }

    public void setRegoNumber(String rego) {
        regoNumber = rego;
    }

    public GreenSlipMessage getGreenSlip() {
        return greenSlip;
    }

    public void setGreenSlip(GreenSlipMessage gs) {
        greenSlip = gs;
    }

    public VehicleMessage getVehicleInfo() {
        return vehicleInfo;
    }

    public void setVehicleInfo(VehicleMessage info) {
        vehicleInfo = info;
    }

    public PinkSlipMessage getPinkSlip() {
        return pinkSlip;
    }

    public void setPinkSlip(PinkSlipMessage ps) {
        pinkSlip = ps;
    }

    public boolean getPinkSlipRequired() {
        return pinkSlipRequired;
    }

    public void setPinkSlipRequired(boolean required) {
        pinkSlipRequired = required;
    }
}

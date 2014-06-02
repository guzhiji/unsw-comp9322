package au.edu.unsw.cse.cs9322.assignment2.rms.data;

import java.util.Date;

public class VehicleMessage {

    private String lastName;
    private String firstName;
    private String regoNumber;
    private Date manufacturedDate;
    private String vehicleType;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lname) {
        lastName = lname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fname) {
        firstName = fname;
    }

    public String getRegoNumber() {
        return regoNumber;
    }

    public void setRegoNumber(String rego) {
        regoNumber = rego;
    }

    public Date getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(Date mdate) {
        manufacturedDate = mdate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String type) {
        vehicleType = type;
    }
}

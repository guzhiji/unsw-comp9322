package au.edu.unsw.cse.cs9322.assignment2.rms.data;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Driver {

    public static String genKey(
            String lastName,
            String firstName,
            String regoNumber) {

        StringBuilder sb = new StringBuilder();
        sb.append(firstName.replace("_", ""));
        sb.append("_");
        sb.append(lastName.replace("_", ""));
        sb.append("_");
        sb.append(regoNumber.replace("_", ""));

        return sb.toString();
    }

    private String lastName;
    private String firstName;
    private String licenceNumber;
    private Date lastRegoDate;
    private String regoNumber;
    private String address;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public Date getLastRegoDate() {
        return lastRegoDate;
    }

    public String getRegoNumber() {
        return regoNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setLastName(String lname) {
        lastName = lname;
    }

    public void setFirstName(String fname) {
        firstName = fname;
    }

    public void setLicenceNumber(String l) {
        licenceNumber = l;
    }

    public void setLastRegoDate(Date d) {
        lastRegoDate = d;
    }

    public void setRegoNumber(String regoNum) {
        regoNumber = regoNum;
    }

    public void setAddress(String addr) {
        address = addr;
    }

    public String getKey() {
        return genKey(lastName, firstName, regoNumber);
    }
}

package au.edu.unsw.cse.cs9322.assignment2.rms.data;

public class GreenSlipMessage {

    private String lastName;
    private String firstName;
    private String regoNumber;
    private boolean paidFlag;

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

    public boolean getPaidFlag() {
        return paidFlag;
    }

    public void setPaidFlag(boolean paid) {
        paidFlag = paid;
    }
}

package au.edu.unsw.cse.cs9322.assignment2.rms.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RequestItem {

    private String id;
    private String lastName;
    private String firstName;
    private String licenceNumber;
    private String regoNumber;
    private String address;
    private RequestStatus status;
    private String rejectReason;
    private String paymentId;
    private String autoCheckResultId;

    RequestItem(RequestItem r) {
        lastName = r.lastName;
        firstName = r.firstName;
        licenceNumber = r.licenceNumber;
        regoNumber = r.regoNumber;
        address = r.address;
        id = r.id;
        status = r.status;
        rejectReason = r.rejectReason;
    }

    public RequestItem() {
        status = RequestStatus.NEW;
    }

    public RequestItem(String lname, String fname, String licence,
            String regoNum, String addr) {
        lastName = lname;
        firstName = fname;
        licenceNumber = licence;
        regoNumber = regoNum;
        address = addr;
        id = null;
        status = RequestStatus.NEW;
        rejectReason = null;
    }

    public RequestItem(String rid, RequestStatus s, String lname,
            String fname, String licence, String regoNum, String addr,
            String reason) {
        id = rid;
        status = s;
        lastName = lname;
        firstName = fname;
        licenceNumber = licence;
        regoNumber = regoNum;
        address = addr;
        rejectReason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String reqId) {
        id = reqId;
    }

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

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licence) {
        licenceNumber = licence;
    }

    public String getRegoNumber() {
        return regoNumber;
    }

    public void setRegoNumber(String regoNum) {
        regoNumber = regoNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addr) {
        address = addr;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus s) {
        status = s;
    }

    public boolean isRejected() {
        return rejectReason != null;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String reason) {
        rejectReason = reason;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String id) {
        paymentId = id;
    }

    public String getAutoCheckResultId() {
        return autoCheckResultId;
    }

    public void setAutoCheckResultId(String id) {
        autoCheckResultId = id;
    }
}

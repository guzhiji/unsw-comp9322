/**
 * PinkSlipFaultException.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators;

public class PinkSlipFaultException extends java.lang.Exception {

    private static final long serialVersionUID = 1401420111501L;

    private au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault faultMessage;

    public PinkSlipFaultException() {
        super("PinkSlipFaultException");
    }

    public PinkSlipFaultException(java.lang.String s) {
        super(s);
    }

    public PinkSlipFaultException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public PinkSlipFaultException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault msg) {
        faultMessage = msg;
    }

    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.elemonators.PinkSlipServicesStub.PinkSlipFault getFaultMessage() {
        return faultMessage;
    }
}

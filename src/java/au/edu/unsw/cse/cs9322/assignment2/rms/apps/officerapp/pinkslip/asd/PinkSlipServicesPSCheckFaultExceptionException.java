/**
 * PinkSlipServicesPSCheckFaultExceptionException.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd;

public class PinkSlipServicesPSCheckFaultExceptionException extends java.lang.Exception {

    private static final long serialVersionUID = 1401419776372L;

    private au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.PinkSlipServicesPSCheckFaultException faultMessage;

    public PinkSlipServicesPSCheckFaultExceptionException() {
        super("PinkSlipServicesPSCheckFaultExceptionException");
    }

    public PinkSlipServicesPSCheckFaultExceptionException(java.lang.String s) {
        super(s);
    }

    public PinkSlipServicesPSCheckFaultExceptionException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public PinkSlipServicesPSCheckFaultExceptionException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.PinkSlipServicesPSCheckFaultException msg) {
        faultMessage = msg;
    }

    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.asd.ASDPinkSlipServicesStub.PinkSlipServicesPSCheckFaultException getFaultMessage() {
        return faultMessage;
    }
}

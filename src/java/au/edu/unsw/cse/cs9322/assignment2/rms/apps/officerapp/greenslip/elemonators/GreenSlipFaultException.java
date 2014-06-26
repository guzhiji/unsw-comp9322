/**
 * GreenSlipFaultException.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.elemonators;

public class GreenSlipFaultException extends java.lang.Exception {

    private static final long serialVersionUID = 1401420109681L;

    private au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.elemonators.GreenSlipServicesStub.GreenSlipFault faultMessage;

    public GreenSlipFaultException() {
        super("GreenSlipFaultException");
    }

    public GreenSlipFaultException(java.lang.String s) {
        super(s);
    }

    public GreenSlipFaultException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public GreenSlipFaultException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.elemonators.GreenSlipServicesStub.GreenSlipFault msg) {
        faultMessage = msg;
    }

    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.elemonators.GreenSlipServicesStub.GreenSlipFault getFaultMessage() {
        return faultMessage;
    }
}

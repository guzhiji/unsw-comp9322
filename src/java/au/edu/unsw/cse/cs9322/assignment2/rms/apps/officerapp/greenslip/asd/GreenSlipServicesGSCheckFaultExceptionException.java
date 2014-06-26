/**
 * GreenSlipServicesGSCheckFaultExceptionException.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.asd;

public class GreenSlipServicesGSCheckFaultExceptionException extends java.lang.Exception {

    private static final long serialVersionUID = 1401419774520L;

    private ASDGreenSlipServicesStub.GreenSlipServicesGSCheckFaultException faultMessage;

    public GreenSlipServicesGSCheckFaultExceptionException() {
        super("GreenSlipServicesGSCheckFaultExceptionException");
    }

    public GreenSlipServicesGSCheckFaultExceptionException(String s) {
        super(s);
    }

    public GreenSlipServicesGSCheckFaultExceptionException(String s, Throwable ex) {
        super(s, ex);
    }

    public GreenSlipServicesGSCheckFaultExceptionException(Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(ASDGreenSlipServicesStub.GreenSlipServicesGSCheckFaultException msg) {
        faultMessage = msg;
    }

    public ASDGreenSlipServicesStub.GreenSlipServicesGSCheckFaultException getFaultMessage() {
        return faultMessage;
    }
}

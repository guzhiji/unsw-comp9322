/**
 * GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj;

public class GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException extends java.lang.Exception {

    private static final long serialVersionUID = 1401419948920L;

    private au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj.GZJGZJGreenSlipProviderStub.GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderException faultMessage;

    public GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException() {
        super("GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException");
    }

    public GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException(java.lang.String s) {
        super(s);
    }

    public GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderExceptionException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj.GZJGZJGreenSlipProviderStub.GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderException msg) {
        faultMessage = msg;
    }

    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip.gzj.GZJGZJGreenSlipProviderStub.GZJGreenSlipProviderGreenSlipProvider_GreenSlipProviderException getFaultMessage() {
        return faultMessage;
    }
}

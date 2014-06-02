/**
 * GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: 1.6.2
 * Built on : Apr 17, 2012 (05:33:49 IST)
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj;

public class GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException extends java.lang.Exception {

    private static final long serialVersionUID = 1401419950682L;

    private au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderException faultMessage;

    public GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException() {
        super("GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException");
    }

    public GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException(java.lang.String s) {
        super(s);
    }

    public GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException(java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderExceptionException(java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderException msg) {
        faultMessage = msg;
    }

    public au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip.gzj.GZJGZJPinkSlipProviderStub.GZJPinkSlipProviderPinkSlipProvider_PinkSlipProviderException getFaultMessage() {
        return faultMessage;
    }
}

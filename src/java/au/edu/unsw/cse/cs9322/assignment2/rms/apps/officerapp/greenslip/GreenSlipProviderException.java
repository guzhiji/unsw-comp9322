package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip;

public class GreenSlipProviderException extends Exception {

    public GreenSlipProviderException(String msg) {
        super(msg);
    }

    public GreenSlipProviderException(Throwable cause) {
        super(cause);
    }

    public GreenSlipProviderException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

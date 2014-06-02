package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip;

public class PinkSlipProviderException extends Exception {

    public PinkSlipProviderException(String msg) {
        super(msg);
    }

    public PinkSlipProviderException(Throwable cause) {
        super(cause);
    }

    public PinkSlipProviderException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

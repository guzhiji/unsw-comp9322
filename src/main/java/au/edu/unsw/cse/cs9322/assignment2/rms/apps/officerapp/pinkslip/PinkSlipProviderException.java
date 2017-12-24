package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip;

public class PinkSlipProviderException extends Exception {

    private final String provider;

    public PinkSlipProviderException(String pvd, String msg) {
        super(msg);
        provider = pvd;
    }

    public PinkSlipProviderException(String pvd, Throwable cause) {
        super(cause);
        provider = pvd;
    }

    public PinkSlipProviderException(String pvd, String msg, Throwable cause) {
        super(msg, cause);
        provider = pvd;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public String getMessage() {
        return "[" + provider + "] " + super.getMessage();
    }
}

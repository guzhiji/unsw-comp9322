package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip;

public class GreenSlipProviderException extends Exception {

    private final String provider;

    public GreenSlipProviderException(String pvd, String msg) {
        super(msg);
        provider = pvd;
    }

    public GreenSlipProviderException(String pvd, Throwable cause) {
        super(cause);
        provider = pvd;
    }

    public GreenSlipProviderException(String pvd, String msg, Throwable cause) {
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

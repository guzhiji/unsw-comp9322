package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.greenslip;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.AbstractSoapChecker;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.GreenSlipMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.SoapCheckerMessage;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GreenSlipChecker extends AbstractSoapChecker {

    @Override
    protected SoapCheckerMessage check(
            String pkg,
            ResourceBundle res,
            Enumeration<String> keys,
            SoapCheckerMessage msg) {

        while (keys.hasMoreElements()) {

            String p = keys.nextElement();
            String cls = pkg + "." + p;
            String url = res.getString(p);

            Logger.getLogger(p).log(Level.INFO, "checking green slip provider: {0}", url);

            GreenSlipProvider provider = getProvider(cls, GreenSlipProvider.class, url);
            if (provider == null) {
                Logger.getLogger(p).log(Level.INFO, "provider: {0} is not available", url);
                continue;
            }

            try {

                GreenSlipMessage m = provider.check(
                        msg.getFirstName(),
                        msg.getLastName(),
                        msg.getRegoNumber());

                if (m.getPaidFlag()) {
                    msg.setGreenSlip(m);
                    Logger.getLogger(p).log(Level.INFO, "find a green slip from provider {0}", p);
                    return msg;
                } else {
                    exceptions.add(new GreenSlipProviderException(p, "not paid for a green slip"));
                    Logger.getLogger(p).log(Level.INFO, "registered with green slip provider {0} but not paid", p);
                }

            } catch (GreenSlipProviderException ex) {

                exceptions.add(ex);
                Logger.getLogger(p).log(Level.INFO, ex.getMessage());

            } catch (Exception ex) {

                exceptions.add(ex);
                Logger.getLogger(p).log(Level.WARNING, "exception caught", ex);

            }

        }

        return null;

    }

}

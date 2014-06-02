package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.pinkslip;

import au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp.AbstractSoapChecker;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.PinkSlipMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.SoapCheckerMessage;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.VehicleMessage;
import java.util.Date;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PinkSlipChecker extends AbstractSoapChecker {

    @Override
    protected SoapCheckerMessage check(
            String pkg,
            ResourceBundle res,
            Enumeration<String> keys,
            SoapCheckerMessage msg
    ) throws SoapCheckerException {

        while (keys.hasMoreElements()) {

            String p = keys.nextElement();
            String cls = pkg + "." + p;
            String url = res.getString(p);

            Logger.getLogger(p).log(Level.INFO, "checking pink slip provider: {0}", url);

            PinkSlipProvider provider = getProvider(cls, PinkSlipProvider.class, url);
            if (provider == null) {
                Logger.getLogger(p).log(Level.INFO, "provider: {0} is not available", url);
                continue;
            }

            try {

                VehicleMessage vm = provider.getVehicleInfo(
                        msg.getFirstName(),
                        msg.getLastName(),
                        msg.getRegoNumber());
                msg.setVehicleInfo(vm);

                Date fiveYAgo = new Date(System.currentTimeMillis()
                        - 5 * 365 * 24 * 60 * 60 * 1000);
                boolean psrequired = vm.getManufacturedDate().before(fiveYAgo);
                msg.setPinkSlipRequired(psrequired);
                if (psrequired) {

                    PinkSlipMessage ps = provider.check(
                            msg.getFirstName(),
                            msg.getLastName(),
                            msg.getRegoNumber());
                    msg.setPinkSlip(ps);

                }

                // reaching here without any error means successful
                Logger.getLogger(p).log(Level.INFO, "find a pink slip from provider {0}", p);
                return msg;

            } catch (Exception ex) {
                exceptions.add(ex);
                Logger.getLogger(p).log(Level.WARNING, "exception caught", ex);
            }

        }

        return null;

    }

}

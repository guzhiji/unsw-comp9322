package au.edu.unsw.cse.cs9322.assignment2.rms.apps.officerapp;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.SoapCheckerMessage;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

public abstract class AbstractSoapChecker {

    public class SoapCheckerException extends Exception {

        private final List<Exception> exceptions = new ArrayList<Exception>();

        public SoapCheckerException() {
            super("some errors occurred during checking");
        }

        public List<Exception> getExceptions() {
            return exceptions;
        }

        public boolean isEmpty() {
            return exceptions.isEmpty();
        }

        public void add(Exception ex) {
            exceptions.add(ex);
        }

    }

    protected final SoapCheckerException exceptions;

    protected AbstractSoapChecker() {
        exceptions = new SoapCheckerException();
    }

    private boolean validateInterface(Class<?> cls, Class<?> i) {
        for (Class<?> it : cls.getInterfaces())
            if (it.equals(i))
                return true;
        return false;
    }

    protected <T> T getProvider(String className, Class<T> providerI, String url) {
        try {
            Class<?> cls = Class.forName(className);
            if (!validateInterface(cls, providerI))
                throw new Exception("invalid provider class");
            Constructor<T> c;
            c = (Constructor<T>) cls.getConstructor(String.class);
            return c.newInstance(url);
        } catch (Exception ex) {
            exceptions.add(ex);
            ex.printStackTrace();
            return null;
        }
    }

    public List<Exception> getExceptions() {
        return exceptions.getExceptions();
    }

    protected abstract SoapCheckerMessage check(
            String pkg,
            ResourceBundle res,
            Enumeration<String> keys,
            SoapCheckerMessage msg
    ) throws SoapCheckerException;

    public void check(SoapCheckerMessage msg) throws SoapCheckerException {

        String pkg = getClass().getPackage().getName();
        ResourceBundle res = ResourceBundle.getBundle(
                pkg + ".providers");

        if (check(pkg, res, res.getKeys(), msg) == null) {
            if (exceptions.isEmpty())
                exceptions.add(new Exception("no provider is available"));
            throw exceptions;
        }

    }
}

package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.Payment;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentDB {

    public static class PaymentDBException extends Exception {

        public PaymentDBException(String msg) {
            super(msg);
        }

        public PaymentDBException(String msg, Throwable t) {
            super(msg, t);
        }
    }

    private static class DB implements DBBackupService.AutoBackupCapableDB {

        private final ConcurrentHashMap<String, Payment> storage = new ConcurrentHashMap<String, Payment>();
        boolean modified = false;

        synchronized Payment create(String id, float fee) throws PaymentDBException {
            if (storage.containsKey(id)) {
                throw new PaymentDBException("Payment id already exists.");
            }
            Payment p = new Payment(id, fee);
            storage.put(id, p);
            modified = true;
            return p;
        }

        synchronized Payment get(String id) throws PaymentDBException {
            Payment p = storage.get(id);
            if (p == null)
                throw new PaymentDBException("The payment id does not exist.");
            return p;
        }

        public boolean exists(String id) {
            return storage.containsKey(id);
        }

        synchronized void remove(String id) {
            storage.remove(id);
            modified = true;
        }

        synchronized void clear() {
            storage.clear();
            modified = true;
        }

        @Override
        public void backUp(File path) {

            File repo = new File(path, PaymentDB.class.getSimpleName());
            repo.mkdir();

            // map
            File storagefile = new File(repo, "storage");
            try {
                if (storage.isEmpty()) {
                    if (storagefile.exists()) {
                        XMLDecoder dec = new XMLDecoder(new BufferedInputStream(
                                new FileInputStream(storagefile)));
                        storage.putAll((Map<String, Payment>) dec.readObject());
                        dec.close();
                    }
                } else if (modified) {
                    XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(
                            new FileOutputStream(storagefile)));
                    enc.writeObject(storage);
                    enc.close();
                }
                modified = false;
            } catch (Exception ex) {
            }
        }

    }

    public static Payment create(String id, float fee) throws PaymentDBException {
        return instance.create(id, fee);
    }

    public static Payment get(String id) throws PaymentDBException {
        return instance.get(id);
    }

    public static boolean exists(String id) {
        return instance.exists(id);
    }

    public static void remove(String id) {
        instance.remove(id);
    }

    public static void clear() {
        instance.clear();
    }
    private final static DB instance;

    static {
        instance = new DB();
        DBBackupService.register(instance);
    }

    private PaymentDB() {
    }
}

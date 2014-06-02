package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.SoapCheckerMessage;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CheckResultDB {

    public static class CheckResultDBException extends Exception {

        public CheckResultDBException(String msg) {
            super(msg);
        }

        public CheckResultDBException(String msg, Throwable t) {
            super(msg, t);
        }
    }

    private static class DB implements DBBackupService.AutoBackupCapableDB {

        private final ConcurrentHashMap<String, SoapCheckerMessage> storage = new ConcurrentHashMap<String, SoapCheckerMessage>();
        private boolean modified = false;

        synchronized void create(SoapCheckerMessage msg) throws CheckResultDBException {
            if (storage.containsKey(msg.getId())) {
                throw new CheckResultDBException("Check result id already exists.");
            }
            storage.put(msg.getId(), msg);
            modified = true;
        }

        synchronized SoapCheckerMessage get(String id) throws CheckResultDBException {
            SoapCheckerMessage p = storage.get(id);
            if (p == null)
                throw new CheckResultDBException("The check result id does not exist.");
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

            File repo = new File(path, CheckResultDB.class.getSimpleName());
            repo.mkdir();

            // map
            File storagefile = new File(repo, "storage");
            try {
                if (storage.isEmpty()) {
                    if (storagefile.exists()) {
                        XMLDecoder dec = new XMLDecoder(new BufferedInputStream(
                                new FileInputStream(storagefile)));
                        storage.putAll((Map<String, SoapCheckerMessage>) dec.readObject());
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

    public static void create(SoapCheckerMessage msg) throws CheckResultDBException {
        instance.create(msg);
    }

    public static SoapCheckerMessage get(String id) throws CheckResultDBException {
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

    private CheckResultDB() {
    }
}

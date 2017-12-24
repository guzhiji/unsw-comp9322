package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * map users to server-side dynamically-generated ids
 */
public class UserIdDB implements DBBackupService.AutoBackupCapableDB {

    @Override
    public void backUp(File path) {

        File repo = new File(path, getClass().getSimpleName());
        repo.mkdir();

        // map
        File storagefile = new File(repo, "storage");
        try {
            if (storage.isEmpty()) {
                if (storagefile.exists()) {
                    XMLDecoder dec = new XMLDecoder(new BufferedInputStream(
                            new FileInputStream(storagefile)));
                    storage.putAll((Map<String, UserId>) dec.readObject());
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

    public static class UserIdDBException extends Exception {

        public UserIdDBException(String msg) {
            super(msg);
        }
    }

    public static class UserId {

        String id;
        String pass;

        public UserId() {

        }

        UserId(String id, String pass) {
            this.id = id;
            this.pass = pass;
        }

        public String getId() {
            return id;
        }

        public void setId(String uid) {
            id = uid;
        }

        public String getPass() {
            return pass;
        }

        public void setPass(String pwd) {
            pass = pwd;
        }
    }
    private final ConcurrentHashMap<String, UserId> storage = new ConcurrentHashMap<String, UserId>();
    private volatile boolean modified = false;

    public void checkUserInfo(String username, String password) throws UserIdDBException {

        if (username == null || password == null
                || username.isEmpty() || password.isEmpty())
            throw new UserIdDBException("invalid user information");

        if (storage.containsKey(username))
            throw new UserIdDBException("User " + username + " already exists!");

    }

    public synchronized void register(String username, String password, String uid) throws UserIdDBException {

        checkUserInfo(username, password);

        if (uid == null || uid.isEmpty())
            throw new UserIdDBException("user registration failed (id wasn't generated or provided)");

        storage.put(username, new UserId(uid, password));
        modified = true;
    }

    public String getUserId(String username, String password) {
        if (username == null || password == null)
            return null;
        UserId user = storage.get(username);
        if (user == null)
            return null;
        if (user.pass.equals(password))
            return user.id;
        return null;
    }

    public synchronized void unregister(String username) {
        storage.remove(username);
        modified = true;
    }

}

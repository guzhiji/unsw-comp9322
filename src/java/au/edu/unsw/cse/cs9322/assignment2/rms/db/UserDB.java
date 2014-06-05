package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import java.util.concurrent.ConcurrentHashMap;

public class UserDB {

    public static class UserDBException extends Exception {

        public UserDBException(String msg) {
            super(msg);
        }
    }

    private static class User {

        String id;
        String pass;

        User(String id, String pass) {
            this.id = id;
            this.pass = pass;
        }
    }
    private final ConcurrentHashMap<String, User> storage = new ConcurrentHashMap<String, User>();

    public void checkUserInfo(String username, String password) throws UserDBException {

        if (username == null || password == null
                || username.isEmpty() || password.isEmpty())
            throw new UserDBException("invalid user information");

        if (storage.containsKey(username))
            throw new UserDBException("User " + username + " already exists!");

    }

    public void register(String username, String password, String id) throws UserDBException {

        checkUserInfo(username, password);

        if (id == null || id.isEmpty())
            throw new UserDBException("user registration failed (id wasn't generated)");

        storage.put(username, new User(id, password));
    }

    public String getUserId(String username, String password) {
        if (username == null || password == null)
            return null;
        User user = storage.get(username);
        if (user == null)
            return null;
        if (user.pass.equals(password))
            return user.id;
        return null;
    }

    public void unregister(String username) {
        storage.remove(username);
    }

    public static void checkInit() {
    }

}

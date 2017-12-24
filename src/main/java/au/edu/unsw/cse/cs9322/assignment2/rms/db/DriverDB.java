/*
 * DriverDB.java
 *
 * Author: Zhiji Gu <zhiji.gu@student.unsw.edu.au>
 * UNSW Student ID: 3471410
 * Version: 2014s1.comp9322.a1.p2.0501
 */
package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.Driver;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/**
 * the main database in memory storing drivers in
 * {@link http://www.cse.unsw.edu.au/~hpaik/9322/assignments/ass01/DriversDB.txt}.
 */
public final class DriverDB {

    public static class DriverDBException extends Exception {

        public DriverDBException(String msg) {
            super(msg);
        }

        public DriverDBException(String msg, Throwable t) {
            super(msg, t);
        }
    }

    public static class DriverNotFoundException extends DriverDBException {

        public DriverNotFoundException() {
            super("driver not found");
        }
    }

    public static class InvalidDriverQueryException extends DriverDBException {

        public InvalidDriverQueryException() {
            super("invalid driver query");
        }

        public InvalidDriverQueryException(Throwable t) {
            super("invalid driver query", t);
        }
    }

    public static class DriverQuery {

        private String lastName;
        private String firstName;
        private String regoNumber;

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getRegoNumber() {
            return regoNumber;
        }

        public void setLastName(String lname) {
            lastName = lname;
        }

        public void setFirstName(String fname) {
            firstName = fname;
        }

        public void setRegoNumber(String regoNum) {
            regoNumber = regoNum;
        }
    }

    private static class DB implements DBBackupService.AutoBackupCapableDB {

        /**
         * the hashmap storage in memory.
         */
        private final ConcurrentHashMap<String, Driver> storage = new ConcurrentHashMap<String, Driver>();
        volatile boolean modified = false;

        /**
         * find the specified driver by name and rego number.
         */
        public Driver find(
                String lastName,
                String firstName,
                String regoNumber) throws DriverDBException {

            Driver d = storage.get(genKey(lastName, firstName, regoNumber));
            if (d == null) {
                throw new DriverNotFoundException();
            }
            return d;

        }

        /**
         * find the specified driver by a DriverQuery object.
         */
        public Driver find(DriverQuery q) throws DriverDBException {

            return find(q.lastName, q.firstName, q.regoNumber);

        }

        public void add(Driver d) throws DriverDBException {
            storage.put(genKey(d), d);
            modified = true;
        }

        public void update(DriverQuery q, Driver d) throws DriverDBException {
            storage.put(genKey(q), d);
            modified = true;
        }

        public void remove(DriverQuery q) throws DriverDBException {
            storage.remove(genKey(q));
            modified = true;
        }

        public void update(Driver q, Driver d) throws DriverDBException {
            storage.put(genKey(q), d);
            modified = true;
        }

        public void remove(Driver q) throws DriverDBException {
            storage.remove(genKey(q));
            modified = true;
        }

        public void clear() {
            storage.clear();
            modified = true;
        }

        @Override
        public void backUp(File path) {

            File repo = new File(path, DriverDB.class.getSimpleName());
            repo.mkdir();

            // map
            File storagefile = new File(repo, "storage");
            try {
                if (storage.isEmpty()) {
                    if (storagefile.exists()) {
                        XMLDecoder dec = new XMLDecoder(new BufferedInputStream(
                                new FileInputStream(storagefile)));
                        storage.putAll((Map<String, Driver>) dec.readObject());
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

    /**
     * convert string date into a java.util.Date object.
     *
     * @param date data string in dd/MM/yyyy
     * @return
     * @throws ParseException
     */
    private static Date parseDate(String date) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        TimeZone tz = TimeZone.getTimeZone("GMT");
        df.setTimeZone(tz);

        return df.parse(date);
    }

    /**
     * generate a string key from an Driver object.
     */
    public static String genKey(Driver d) throws InvalidDriverQueryException {
        return genKey(d.getLastName(), d.getFirstName(), d.getRegoNumber());
    }

    public static String genKey(DriverQuery d) throws InvalidDriverQueryException {
        return genKey(d.getLastName(), d.getFirstName(), d.getRegoNumber());
    }

    /**
     * generate a string key from driver name and rego number.
     */
    public static String genKey(
            String lastName,
            String firstName,
            String regoNumber) throws InvalidDriverQueryException {
        try {

            if (lastName == null || lastName.isEmpty())
                throw new Exception("last name is missing");
            if (firstName == null || firstName.isEmpty())
                throw new Exception("first name is missing");
            if (regoNumber == null || regoNumber.isEmpty())
                throw new Exception("rego number is missing");

            return Driver.genKey(lastName, firstName, regoNumber);

        } catch (Throwable t) {
            throw new InvalidDriverQueryException(t);
        }
    }
    private final static DB instance;

    static {

        DB s = new DB();

        // initialization: load data
        String[][] data = {
            {"Nima", "Nishad", "D123456", "14/04/2013", "YYZ908"},
            {"Chopra", "Anthony Singh", "M3456789", "28/07/2013", "MMD123"},
            {"Lanker", "Tarin", "M9876578", "15/07/2013", "1NSW1"},
            {"Deng", "Zhang", "L9842873", "15/07/2013", "NAQ900"},
            {"Jordan", "Michael", "D2341764", "20/05/2013", "ACM891"},
            {"Haradi", "Souka Azadeh", "N7788643", "20/12/2013", "BNZ100"},
            {"Go", "Henry", "K9287381", "20/11/2013", "NSZ134"},
            {"Hu", "Luming", "N9101298", "20/08/2013", "CNZ913"}
        };
        try {
            for (String[] row : data) {
                Driver d = new Driver();
                d.setLastName(row[0]);
                d.setFirstName(row[1]);
                d.setLicenceNumber(row[2]);
                d.setLastRegoDate(parseDate(row[3]));
                d.setRegoNumber(row[4]);
                d.setAddress("");
                s.add(d);
            }
        } catch (ParseException ex) {
        } catch (InvalidDriverQueryException ex) {
        } catch (DriverDBException ex) {
        }
        instance = s;
        DBBackupService.register(instance);
    }

    public static void checkInit() {

    }

    /**
     * find the specified driver by name and rego number.
     */
    public static Driver find(
            String lastName,
            String firstName,
            String regoNumber) throws DriverDBException {

        return instance.find(lastName, firstName, regoNumber);

    }

    /**
     * find the specified driver by a DriverQuery object.
     */
    public static Driver find(DriverQuery q) throws DriverDBException {

        return instance.find(q.lastName, q.firstName, q.regoNumber);

    }

    public static void add(Driver d) throws DriverDBException {
        instance.add(d);
    }

    public static void update(DriverQuery q, Driver d) throws DriverDBException {
        instance.update(q, d);
    }

    public static void remove(DriverQuery q) throws DriverDBException {
        instance.remove(q);
    }

    public static void update(Driver q, Driver d) throws DriverDBException {
        instance.update(q, d);
    }

    public static void remove(Driver q) throws DriverDBException {
        instance.remove(q);
    }

    public void clear() {
        instance.clear();
    }

}

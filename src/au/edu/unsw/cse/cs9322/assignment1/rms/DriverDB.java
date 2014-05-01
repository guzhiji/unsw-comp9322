/*
 * DriverDB.java
 *
 * Author: Zhiji Gu <zhiji.gu@student.unsw.edu.au>
 * UNSW Student ID: 3471410
 * Version: 2014s1.comp9322.a1.p2.0501
 */
package au.edu.unsw.cse.cs9322.assignment1.rms;

import com.csvreader.CsvReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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

    public static class Driver {

        private String lastName;
        private String firstName;
        private String licenceNumber;
        private Date lastRegoDate;
        private String regoNumber;

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLicenceNumber() {
            return licenceNumber;
        }

        public Date getLastRegoDate() {
            return lastRegoDate;
        }

        public String getRegoNumber() {
            return regoNumber;
        }

        void setLastName(String lname) {
            lastName = lname;
        }

        void setFirstName(String fname) {
            firstName = fname;
        }

        void setLicenceNumber(String l) {
            licenceNumber = l;
        }

        void setLastRegoDate(Date d) {
            lastRegoDate = d;
        }

        void setRegoNumber(String regoNum) {
            regoNumber = regoNum;
        }
    }
    /**
     * URL where all data are loaded.
     */
    public final static String DB_URL = "http://www.cse.unsw.edu.au/~hpaik/9322/assignments/ass01/DriversDB.txt";
    /**
     * the hashmap storage in memory.
     */
    private static ConcurrentHashMap<String, Driver> storage;

    static {

        // initialization: load data

        ConcurrentHashMap<String, Driver> s = new ConcurrentHashMap<String, Driver>();
        CsvReader reader = null;
        try {

            boolean isFirst = true;
            URL url = new URL(DB_URL);
            reader = new CsvReader(new InputStreamReader(url.openStream()));
            while (reader.readRecord()) {
                try {
                    //LName,FName,LNumber,LastRegoDate,RegoNumber
                    if (isFirst && reader.get(0).equalsIgnoreCase("LName")) {
                        isFirst = false;
                        continue;
                    }
                    Driver d = new Driver();
                    d.setLastName(reader.get(0));
                    d.setFirstName(reader.get(1));
                    d.setLicenceNumber(reader.get(2));
                    d.setLastRegoDate(parseDate(reader.get(3)));
                    d.setRegoNumber(reader.get(4));
                    s.put(genKey(d.lastName, d.firstName, d.regoNumber), d);
                } catch (Exception ex) {
                }
            }

        } catch (Exception ex) {
            System.err.println("Data could not be loaded from " + DB_URL);
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
                    s.put(genKey(d.lastName, d.firstName, d.regoNumber), d);
                }
            } catch (Exception ex2) {
            }
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ex) {
                }
            }
            storage = s;
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
        return genKey(d.lastName, d.firstName, d.regoNumber);
    }

    /**
     * generate a string key from driver name and rego number.
     */
    public static String genKey(
            String lastName,
            String firstName,
            String regoNumber) throws InvalidDriverQueryException {
        try {

            if (lastName == null || lastName.isEmpty()) {
                throw new Exception("last name is missing");
            }
            if (firstName == null || firstName.isEmpty()) {
                throw new Exception("first name is missing");
            }
            if (regoNumber == null || regoNumber.isEmpty()) {
                throw new Exception("rego number is missing");
            }

            StringBuilder sb = new StringBuilder();
            sb.append(lastName.replace("_", ""));
            sb.append("_");
            sb.append(firstName.replace("_", ""));
            sb.append("_");
            sb.append(regoNumber.replace("_", ""));

            return sb.toString();

        } catch (Throwable t) {
            throw new InvalidDriverQueryException(t);
        }
    }

    /**
     * find the specified driver by name and rego number.
     */
    public static Driver find(
            String lastName,
            String firstName,
            String regoNumber) throws DriverDBException {

        Driver d = storage.get(genKey(lastName, firstName, regoNumber));
        if (d == null) {
            throw new DriverNotFoundException();
        }
        return d;

    }
}

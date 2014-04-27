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

public final class DriverDB {

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
    public final static String DB_URL = "http://www.cse.unsw.edu.au/~hpaik/9322/assignments/ass01/DriversDB.txt";
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

            }

        } catch (Exception ex) {
            System.err.println("Data could not be loaded from " + DB_URL);
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

    private static Date parseDate(String date) throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        TimeZone tz = TimeZone.getTimeZone("GMT");
        df.setTimeZone(tz);

        return df.parse(date);
    }

    public static String genKey(Driver d) {
        return genKey(d.lastName, d.firstName, d.regoNumber);
    }

    public static String genKey(
            String lastName,
            String firstName,
            String regoNumber) {

        StringBuilder sb = new StringBuilder();
        sb.append(lastName.replace("_", ""));
        sb.append("_");
        sb.append(firstName.replace("_", ""));
        sb.append("_");
        sb.append(regoNumber.replace("_", ""));

        return sb.toString();

    }

    public static Driver find(
            String lastName,
            String firstName,
            String regoNumber) {

        return storage.get(genKey(lastName, firstName, regoNumber));

    }
}

/*
 * GreenSlipProvider.java
 *
 * Author: Zhiji Gu <zhiji.gu@student.unsw.edu.au>
 * UNSW Student ID: 3471410
 * Version: 2014s1.comp9322.a1.p2.0501
 */
package au.edu.unsw.cse.cs9322.assignment2.rms;

import au.edu.unsw.cse.cs9322.assignment2.rms.db.DriverDB;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * the Green Slip Provider service.
 */
public final class GreenSlipProvider {

    public static class GreenSlipProviderException extends Exception {

        public GreenSlipProviderException(String msg) {
            super(msg);
        }

        public GreenSlipProviderException(Throwable cause) {
            super(cause);
        }

        public GreenSlipProviderException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    /**
     * the green slip database in memory.
     */
    private static class GreenSlipDB {

        private static final Set<String> storage;

        static {
            storage = Collections.synchronizedSet(new HashSet<String>());
            try {
                add(DriverDB.find("Nima", "Nishad", "YYZ908"));
                add(DriverDB.find("Jordan", "Michael", "ACM891"));
                add(DriverDB.find("Haradi", "Souka Azadeh", "BNZ100"));
            } catch (DriverDB.DriverDBException ex) {
            }
        }

        /**
         * check if a driver has paid for a green slip.
         */
        public static boolean find(DriverDB.Driver d) throws DriverDB.DriverDBException {

            return storage.contains(DriverDB.genKey(d));

        }

        /**
         * add a new driver who has paid for a green slip.
         */
        public static void add(DriverDB.Driver d) throws DriverDB.DriverDBException {

            storage.add(DriverDB.genKey(d));

        }

        /**
         * remove a driver whose green slip's expired.
         */
        public static void remove(DriverDB.Driver d) throws DriverDB.DriverDBException {
            storage.remove(DriverDB.genKey(d));
        }
    }

    /**
     * green slip SOAP message.
     */
    public class GSMessage {

        private final String lastName;
        private final String firstName;
        private final String regoNumber;
        private final boolean paidFlag;

        GSMessage(DriverDB.Driver d, boolean paid) {
            lastName = d.getLastName();
            firstName = d.getFirstName();
            regoNumber = d.getRegoNumber();
            paidFlag = paid;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getRegoNumber() {
            return regoNumber;
        }

        public boolean getPaidFlag() {
            return paidFlag;
        }
    }

    /**
     * Service Method: check green slip for a driver.
     *
     * @param q
     * @return
     * @throws
     * au.edu.unsw.cse.cs9322.assignment2.rms.GreenSlipProvider.GreenSlipProviderException
     */
    public GSMessage GSCheck(DriverDB.DriverQuery q) throws GreenSlipProviderException {
        try {
            DriverDB.Driver d = DriverDB.find(q);
            return new GSMessage(d, GreenSlipDB.find(d));
        } catch (DriverDB.DriverDBException t) {
            throw new GreenSlipProviderException(t);
        }
    }
}

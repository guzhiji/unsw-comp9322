/*
 * PinkSlipProvider.java
 *
 * Author: Zhiji Gu <zhiji.gu@student.unsw.edu.au>
 * UNSW Student ID: 3471410
 * Version: 2014s1.comp9322.a1.p2.0501
 */
package au.edu.unsw.cse.cs9322.assignment1.rms;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * the Pink Slip Provider service.
 */
public final class PinkSlipProvider {

    public static class PinkSlipProviderException extends Exception {

        public PinkSlipProviderException(String msg) {
            super(msg);
        }

        public PinkSlipProviderException(Throwable cause) {
            super(cause);
        }

        public PinkSlipProviderException(String msg, Throwable cause) {
            super(msg, cause);
        }
    }

    /**
     * the in memory database storing vehicle data.
     */
    private static class VehicleDB {

        private static ConcurrentHashMap<String, Vehicle> storage;

        static {
            storage = new ConcurrentHashMap<String, Vehicle>();
            try {
                add(DriverDB.find("Nima", "Nishad", "YYZ908"), new Date(System.currentTimeMillis()), "Light");
                add(DriverDB.find("Chopra", "Anthony Singh", "MMD123"), new Date(System.currentTimeMillis()), "Light");
                add(DriverDB.find("Lanker", "Tarin", "1NSW1"), new Date(System.currentTimeMillis()), "Light");
                add(DriverDB.find("Deng", "Zhang", "NAQ900"), new Date(System.currentTimeMillis()), "Light");
                add(DriverDB.find("Jordan", "Michael", "ACM891"), new Date(System.currentTimeMillis()), "Heavy");
                add(DriverDB.find("Haradi", "Souka Azadeh", "BNZ100"), new Date(System.currentTimeMillis()), "Light");
                add(DriverDB.find("Go", "Henry", "NSZ134"), new Date(System.currentTimeMillis()), "Heavy");
                add(DriverDB.find("Hu", "Luming", "CNZ913"), new Date(System.currentTimeMillis()), "Light");
            } catch (Exception ex) {
            }
        }

        public static class VehicleNotFoundException extends Exception {

            public VehicleNotFoundException() {
                super("vehicle not found");
            }
        }

        public static class Vehicle {

            private Date manufacturedDate;
            private String vehicleType;

            public Date getManufacturedDate() {
                return manufacturedDate;
            }

            public String getVehicleType() {
                return vehicleType;
            }

            void setManufacturedDate(Date date) {
                manufacturedDate = date;
            }

            void setVehicleType(String type) {
                vehicleType = type;
            }
        }

        /**
         * find vehicle information for a driver.
         */
        public static Vehicle find(DriverDB.Driver d) throws DriverDB.DriverDBException, VehicleNotFoundException {

            Vehicle v = storage.get(DriverDB.genKey(d));
            if (v == null) {
                throw new VehicleNotFoundException();
            }
            return v;

        }

        /**
         * save vehicle information for a driver.
         */
        public static void add(DriverDB.Driver d, Date mdate, String type) throws DriverDB.DriverDBException {

            Vehicle v = new Vehicle();
            v.manufacturedDate = mdate;
            v.vehicleType = type;
            storage.put(DriverDB.genKey(d), v);

        }

        /**
         * remove a vehicle that has been sold or recycled.
         */
        public static void remove(DriverDB.Driver d) throws DriverDB.DriverDBException {

            storage.remove(DriverDB.genKey(d));

        }
    }

    /**
     * vehicle info SOAP message.
     */
    public class VehicleMessage {

        private String lastName;
        private String firstName;
        private String regoNumber;
        private Date manufacturedDate;
        private String vehicleType;

        VehicleMessage(DriverDB.Driver d, VehicleDB.Vehicle v) {
            lastName = d.getLastName();
            firstName = d.getFirstName();
            regoNumber = d.getRegoNumber();
            manufacturedDate = v.getManufacturedDate();
            vehicleType = v.getVehicleType();
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

        public Date getManufacturedDate() {
            return manufacturedDate;
        }

        public String getVehicleType() {
            return vehicleType;
        }
    }

    /**
     * the pink slip database in memory.
     */
    private static class PinkSlipDB {

        private static Set<String> storage;

        static {
            storage = Collections.synchronizedSet(new HashSet<String>());
            try {
                add(DriverDB.find("Nima", "Nishad", "YYZ908"));
                add(DriverDB.find("Jordan", "Michael", "ACM891"));
                add(DriverDB.find("Deng", "Zhang", "NAQ900"));
            } catch (Exception ex) {
            }
        }

        /**
         * check if a driver's vehicle has passed safety check.
         */
        public static boolean find(DriverDB.Driver d) throws DriverDB.DriverDBException {

            return storage.contains(DriverDB.genKey(d));

        }

        /**
         * add a new driver whose vehicle has passed safety check.
         */
        public static void add(DriverDB.Driver d) throws DriverDB.DriverDBException {

            storage.add(DriverDB.genKey(d));

        }

        /**
         * remove a driver whose pink slip has expired.
         */
        public static void remove(DriverDB.Driver d) throws DriverDB.DriverDBException {

            storage.remove(DriverDB.genKey(d));

        }
    }

    /**
     * pink slip SOAP message.
     */
    public class PSMessage {

        private String lastName;
        private String firstName;
        private String regoNumber;
        private boolean checkedFlag;

        PSMessage(DriverDB.Driver d, boolean checked) {
            lastName = d.getLastName();
            firstName = d.getFirstName();
            regoNumber = d.getRegoNumber();
            checkedFlag = checked;
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

        public boolean getCheckedFlag() {
            return checkedFlag;
        }
    }

    /**
     * Service Method: check pink slip for a driver.
     *
     * @param lastName
     * @param firstName
     * @param regoNumber
     * @return
     * @throws
     * au.edu.unsw.cse.cs9322.assignment1.rms.PinkSlipProvider.PinkSlipProviderException
     */
    public PSMessage PSCheck(DriverDB.DriverQuery q) throws PinkSlipProviderException {
        try {
            DriverDB.Driver d = DriverDB.find(q);
            return new PSMessage(d, PinkSlipDB.find(d));
        } catch (Throwable t) {
            throw new PinkSlipProviderException(t);
        }
    }

    /**
     * Service Method: find vehicle information for a driver.
     *
     * @param lastName
     * @param firstName
     * @param regoNumber
     * @return
     * @throws
     * au.edu.unsw.cse.cs9322.assignment1.rms.PinkSlipProvider.PinkSlipProviderException
     */
    public VehicleMessage VehicleInfo(DriverDB.DriverQuery q) throws PinkSlipProviderException {
        try {
            DriverDB.Driver d = DriverDB.find(q);
            VehicleDB.Vehicle v = VehicleDB.find(d);
            return new VehicleMessage(d, v);
        } catch (Throwable t) {
            throw new PinkSlipProviderException(t);
        }
    }
}

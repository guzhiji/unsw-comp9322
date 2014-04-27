package au.edu.unsw.cse.cs9322.assignment1.rms;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class PinkSlipProvider {

    private static class VehicleDB {

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
        private static ConcurrentHashMap<String, Vehicle> storage = new ConcurrentHashMap<String, Vehicle>();

        public static Vehicle find(DriverDB.Driver d) {

            return storage.get(DriverDB.genKey(d));

        }

        public static void add(DriverDB.Driver d, Date mdate, String type) {

            Vehicle v = new Vehicle();
            v.manufacturedDate = mdate;
            v.vehicleType = type;
            storage.put(DriverDB.genKey(d), v);

        }
    }

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

    private static class PinkSlipDB {

        private static Set<String> storage = Collections.synchronizedSet(new HashSet<String>());

        public static boolean find(DriverDB.Driver d) {

            return storage.contains(DriverDB.genKey(d));

        }

        public static void add(DriverDB.Driver d) {

            storage.add(DriverDB.genKey(d));

        }
    }

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

    public PSMessage PSCheck(
            String lastName,
            String firstName,
            String regoNumber) throws Exception {

        DriverDB.Driver d = DriverDB.find(lastName, firstName, regoNumber);
        if (d == null) {
            throw new Exception("driver not found");
        }
        return new PSMessage(d, PinkSlipDB.find(d));

    }

    public VehicleMessage VehicleInfo(
            String lastName,
            String firstName,
            String regoNumber) throws Exception {

        DriverDB.Driver d = DriverDB.find(lastName, firstName, regoNumber);
        if (d == null) {
            throw new Exception("driver not found");
        }
        VehicleDB.Vehicle v = VehicleDB.find(d);
        if (v == null) {
            throw new Exception("vehicle not found");
        }
        return new VehicleMessage(d, v);

    }
}

package au.edu.unsw.cse.cs9322.assignment1.rms;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class GreenSlipProvider {

    private static class GreenSlipDB {

        private static Set<String> storage = Collections.synchronizedSet(new HashSet<String>());

        public static boolean find(DriverDB.Driver d) {

            return storage.contains(DriverDB.genKey(d));

        }

        public static void add(DriverDB.Driver d) {

            storage.add(DriverDB.genKey(d));

        }
    }

    public class GSMessage {

        private String lastName;
        private String firstName;
        private String regoNumber;
        private boolean paidFlag;

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

    public GSMessage GSCheck(
            String lastName,
            String firstName,
            String regoNumber) throws Exception {

        DriverDB.Driver d = DriverDB.find(lastName, firstName, regoNumber);
        if (d == null) {
            throw new Exception("driver not found");
        }

        return new GSMessage(d, GreenSlipDB.find(d));

    }
}

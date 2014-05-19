package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentDB {

    public static class Payment {

        private final String id;
        private float amount;
        private Date paid_date;

        Payment(String id, float fee) {
            this.id = id;
            this.amount = fee;
            this.paid_date = null;
        }

        public String getId() {
            return id;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float fee) {
            amount = fee;
        }

        public Date getPaidDate() {
            return paid_date;
        }

        public void setPaidDate(Date d) {
            paid_date = d;
        }

        public boolean isPaid() {
            return paid_date != null;
        }
    }
    private static final ConcurrentHashMap<String, Payment> storage = new ConcurrentHashMap<String, Payment>();

    public static Payment create(String id, float fee) {
        if (storage.containsKey(id)) {
            return null;
        }
        Payment p = new Payment(id, fee);
        storage.put(id, p);
        return p;
    }

    public static Payment get(String id) {
        return storage.get(id);
    }

    public static boolean exists(String id) {
        return storage.containsKey(id);
    }

    public static void remove(String id) {
        storage.remove(id);
    }

    public static void clear() {
        storage.clear();
    }
}

package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RequestDB {

    public static class RequestDBException extends Exception {

        public RequestDBException(String msg) {
            super(msg);
        }

        public RequestDBException(String msg, Throwable t) {
            super(msg, t);
        }
    }

    public static enum Status {

        NEW, // wait for an officer
        UNDER_REVIEW, // requester cannot modify
        ACCEPTED, // requester needs to pay
        ARCHIVED; // finished & officers won't see it
    }

    public static class Request {

        private String id;
        private String lastName;
        private String firstName;
        private String licenceNumber;
        private String regoNumber;
        private String address;
        private Status status;
        private String rejectReason;

        Request(Request r) {
            lastName = r.lastName;
            firstName = r.firstName;
            licenceNumber = r.licenceNumber;
            regoNumber = r.regoNumber;
            address = r.address;
            id = r.id;
            status = r.status;
            rejectReason = r.rejectReason;
        }

        public Request() {
        }

        public Request(String lname, String fname, String licence, String regoNum, String addr) {
            lastName = lname;
            firstName = fname;
            licenceNumber = licence;
            regoNumber = regoNum;
            address = addr;
            id = null;
            status = Status.NEW;
            rejectReason = null;
        }

        public String getId() {
            return id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lname) {
            lastName = lname;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstNumber(String fname) {
            firstName = fname;
        }

        public String getLicenceNumber() {
            return licenceNumber;
        }

        public void setLicenceNumber(String licence) {
            licenceNumber = licence;
        }

        public String getRegoNumber() {
            return regoNumber;
        }

        public void setRegoNumber(String regoNum) {
            regoNumber = regoNum;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String addr) {
            address = addr;
        }

        public Status getStatus() {
            return status;
        }

        public boolean isRejected() {
            return rejectReason != null;
        }

        public String getRejectReason() {
            return rejectReason;
        }

        public void setRejectReason(String reason) {
            rejectReason = reason;
        }
    }
    private static final ConcurrentLinkedQueue<Request> queue = new ConcurrentLinkedQueue<Request>();
    private static final ConcurrentHashMap<String, Request> storage = new ConcurrentHashMap<String, Request>();

    public static String genKey() {
        String k;
        do {
            k = String.valueOf(System.currentTimeMillis()) + "-" + String.valueOf((int) (Math.random() * 1000));
        } while (storage.containsKey(k));
        return k;
    }

    public static void add(Request r) {
        r.id = genKey();
        queue.add(r);
        storage.put(r.id, r);
    }

    public static Request get(String id) throws RequestDBException {
        Request r = storage.get(id);
        if (r == null) {
            throw new RequestDBException("Request not found");
        }
        return r;
    }

    public static boolean exists(String id) {
        return storage.containsKey(id);
    }

    public static void updateStatus(String id, Status s) throws RequestDBException {
        Request r = get(id);
        if (s == Status.ARCHIVED) {
            queue.remove(r);
        } else if (r.status == Status.ARCHIVED) {
            queue.add(r);
        }
        r.status = s;
    }

    public static Iterator<Request> getQueueIterator() {
        return queue.iterator();
    }

    public static int getQueueSize() {
        return queue.size();
    }

    public static int getSize() {
        return storage.size();
    }

    public static Request peekQueue() {
        return queue.peek();
    }

    public static void remove(String id) throws RequestDBException {
        Request r = storage.remove(id);
        if (r == null) {
            throw new RequestDBException("Request not found");
        }
        queue.remove(r);
    }

    public static void clear() {
        storage.clear();
        queue.clear();
    }
}

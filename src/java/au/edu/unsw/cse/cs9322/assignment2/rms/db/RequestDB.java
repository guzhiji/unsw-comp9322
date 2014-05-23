package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestList;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;
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

    private static final ConcurrentLinkedQueue<RequestItem> queue = new ConcurrentLinkedQueue<RequestItem>();
    private static final ConcurrentHashMap<String, RequestItem> storage = new ConcurrentHashMap<String, RequestItem>();

    public static String genKey() {
        String k;
        do {
            k = String.valueOf(System.currentTimeMillis()) + String.valueOf((int) (Math.random() * 1000));
        } while (storage.containsKey(k));
        return k;
    }

    public synchronized static void add(RequestItem r) {
        r.setId(genKey());
        queue.add(r);
        storage.put(r.getId(), r);
    }

    public synchronized static void update(String id, RequestItem r) throws RequestDBException {
        RequestItem or = get(id);
        queue.remove(or);
        r.setId(id);
        queue.add(r);
        storage.put(id, r);
    }

    public static RequestItem get(String id) throws RequestDBException {
        RequestItem r = storage.get(id);
        if (r == null) {
            throw new RequestDBException("Request not found");
        }
        return r;
    }

    public static boolean exists(String id) {
        return storage.containsKey(id);
    }

    public synchronized static void updateStatus(String id, RequestStatus s) throws RequestDBException {
        RequestItem r = get(id);
        if (s == RequestStatus.ARCHIVED) {
            queue.remove(r);
        } else if (r.getStatus() == RequestStatus.ARCHIVED) {
            queue.add(r);
        }
        r.setStatus(s);
    }

    public static Iterator<RequestItem> getQueueIterator() {
        return queue.iterator();
    }

    public static RequestList getQueueList() {
        RequestList l = new RequestList();
        l.addAll(queue);
//        for (RequestItem r : queue)
//            l.add(r);
        return l;
    }

    public static int getQueueSize() {
        return queue.size();
    }

    public static int getSize() {
        return storage.size();
    }

    public static RequestItem peekQueue() {
        return queue.peek();
    }

    public synchronized static void remove(String id) throws RequestDBException {
        RequestItem r = storage.remove(id);
        if (r == null) {
            throw new RequestDBException("Request not found");
        }
        queue.remove(r);
    }

    public synchronized static void clear() {
        storage.clear();
        queue.clear();
    }
}

package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestItem;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestList;
import au.edu.unsw.cse.cs9322.assignment2.rms.data.RequestStatus;
import au.edu.unsw.cse.cs9322.assignment2.rms.db.DBBackupService.AutoBackupCapableDB;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
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

    private static class DB implements AutoBackupCapableDB {

        final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
        final ConcurrentHashMap<String, RequestItem> storage = new ConcurrentHashMap<String, RequestItem>();
        volatile boolean modified = false;

        String genKey() {
            String k;
            do {
                k = String.valueOf(System.currentTimeMillis()) + String.valueOf((int) (Math.random() * 1000));
            } while (storage.containsKey(k));
            return k;
        }

        synchronized void add(RequestItem r) {
            String id = genKey();
            r.setId(id);
            queue.add(id);
            storage.put(id, r);
            modified = true;
        }

        synchronized void update(String id, RequestItem r) throws RequestDBException {
            // validate id
            get(id);
            // refresh the queue
            queue.remove(id);
            queue.add(id);
            // update the storage
            r.setId(id);
            storage.put(id, r);
            modified = true;
        }

        RequestItem get(String id) throws RequestDBException {
            RequestItem r = storage.get(id);
            if (r == null) {
                throw new RequestDBException("Request not found");
            }
            return r;
        }

        boolean exists(String id) {
            return storage.containsKey(id);
        }

        synchronized void updateStatus(String id, RequestStatus s) throws RequestDBException {
            RequestItem r = get(id);
            if (s == RequestStatus.ARCHIVED) {
                queue.remove(r.getId());
            } else if (r.getStatus() == RequestStatus.ARCHIVED) {
                queue.add(r.getId());
            }
            r.setStatus(s);
            modified = true;
        }

        Iterator<String> getQueueIterator() {
            return queue.iterator();
        }

        RequestList getList() {
            RequestList l = new RequestList();
            for (String r : queue)
                l.add(storage.get(r));
            return l;
        }

        int getQueueSize() {
            return queue.size();
        }

        int getSize() {
            return storage.size();
        }

        String peekQueue() {
            return queue.peek();
        }

        synchronized void remove(String id) throws RequestDBException {
            RequestItem r = storage.remove(id);
            if (r == null) {
                throw new RequestDBException("Request not found");
            }
            queue.remove(id);
            modified = true;
        }

        synchronized void clear() {
            storage.clear();
            queue.clear();
            modified = true;
        }

        @Override
        public void backUp(File path) {

            File repo = new File(path, RequestDB.class.getSimpleName());
            repo.mkdir();

            // queue
            File queuefile = new File(repo, "queue");
            try {
                if (queue.isEmpty()) {
                    if (queuefile.exists()) {
                        XMLDecoder dec = new XMLDecoder(new BufferedInputStream(
                                new FileInputStream(queuefile)));
                        queue.addAll((Collection<String>) dec.readObject());
                        dec.close();
                    }
                } else if (modified) {
                    XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(
                            new FileOutputStream(queuefile)));
                    enc.writeObject(queue);
                    enc.close();
                }
            } catch (Exception ex) {
            }

            // map
            File storagefile = new File(repo, "storage");
            try {
                if (storage.isEmpty()) {
                    if (storagefile.exists()) {
                        XMLDecoder dec = new XMLDecoder(new BufferedInputStream(
                                new FileInputStream(storagefile)));
                        storage.putAll((Map<String, RequestItem>) dec.readObject());
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

    public static void add(RequestItem r) {
        instance.add(r);
    }

    public static void update(String id, RequestItem r) throws RequestDBException {
        instance.update(id, r);
    }

    public static RequestItem get(String id) throws RequestDBException {
        return instance.get(id);
    }

    public static boolean exists(String id) {
        return instance.exists(id);
    }

    public static void updateStatus(String id, RequestStatus s) throws RequestDBException {
        instance.updateStatus(id, s);
    }

    public static Iterator<String> getQueueIterator() {
        return instance.getQueueIterator();
    }

    public static RequestList getList() {
        return instance.getList();
    }

    public static int getQueueSize() {
        return instance.getQueueSize();
    }

    public static int getSize() {
        return instance.getSize();
    }

    public static String peekQueue() {
        return instance.peekQueue();
    }

    public static void remove(String id) throws RequestDBException {
        instance.remove(id);
    }

    public static void clear() {
        instance.clear();
    }

    public static void checkInit() {
        PaymentDB.checkInit();
        CheckResultDB.checkInit();
    }
    private final static DB instance;

    static {
        instance = new DB();
        DBBackupService.register(instance);
    }

    private RequestDB() {

    }

}

package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBackupService {

    public interface AutoBackupCapableDB {

        void backUp(File path);
    }

    private final File basePath;
    private final List<AutoBackupCapableDB> databases;
    private final ScheduledExecutorService executor;
    private static DBBackupService service;

    DBBackupService(File path) {
        path.mkdir();
        basePath = path;
        executor = Executors.newSingleThreadScheduledExecutor();
        databases = new ArrayList<AutoBackupCapableDB>();
        executor.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {

                Logger.getLogger(getClass().getSimpleName())
                        .log(Level.INFO, "DB backup task begins");

                synchronized (databases) {
                    for (AutoBackupCapableDB db : databases)
                        db.backUp(basePath);
                }

                Logger.getLogger(getClass().getSimpleName())
                        .log(Level.INFO, "DB backup task finishes");

            }
        }, 1, 10, TimeUnit.SECONDS);
    }

    public static void checkStarted(String path) {
        if (service == null)
            service = new DBBackupService(new File(path));
    }

    public static void register(AutoBackupCapableDB cls) {
        if (service != null)
            service.databases.add(cls);
    }

    public static void shutdown() {
        if (service != null)
            service.executor.shutdown();
        Logger.getLogger(DBBackupService.class.getSimpleName())
                .log(Level.INFO, "DBBackupService is shutting down");
    }
}

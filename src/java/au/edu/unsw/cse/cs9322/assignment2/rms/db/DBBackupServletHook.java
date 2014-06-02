package au.edu.unsw.cse.cs9322.assignment2.rms.db;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBBackupServletHook implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DBBackupService.checkStarted(sce.getServletContext().getRealPath("/WEB-INF/data"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBBackupService.shutdown();
    }

}

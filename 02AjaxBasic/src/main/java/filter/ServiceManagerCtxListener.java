package filter;

import persistence.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Created by u0090265 on 3/17/14.
 */
@WebListener
public class ServiceManagerCtxListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        //Clean the JPA resource when application is stopped.
        PersistenceManager.cleanResources();
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
    }
}

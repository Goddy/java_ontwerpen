package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * User: Tom De Dobbeleer
 * Date: 2/7/14
 * Time: 7:27 PM
 * Remarks: none
 */
public class SessionFactoryHelper {

    private SessionFactoryHelper() {}
    public static SessionFactory getSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }
}

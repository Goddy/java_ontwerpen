package persistence;

import org.hibernate.SessionFactory;

/**
 * User: Tom De Dobbeleer
 * Date: 2/7/14
 * Time: 7:01 PM
 * Remarks: none
 */
public class DaoFactory {
    private DaoFactory() {}
    public static HbnClientDao getClientDao() { return new HbnClientDao(SessionFactoryHelper.getSessionFactory()); }
}

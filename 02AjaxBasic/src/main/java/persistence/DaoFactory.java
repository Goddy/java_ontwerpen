package persistence;

/**
 * User: Tom De Dobbeleer
 * Date: 2/7/14
 * Time: 7:01 PM
 * Remarks: none
 */
public class DaoFactory {
    private DaoFactory() {}
    public static JpaClientDao getClientDao() { return new JpaClientDao(PersistenceManager.getEntityManager()); }
    public static JpaEmployeeDao getEmployeeDao() { return new JpaEmployeeDao(PersistenceManager.getEntityManager()); }
    public static JpaServiceCallDao getServiceCallDao() { return new JpaServiceCallDao(PersistenceManager.getEntityManager()); }
    public static JpaDaoImpl getHbnDao() { return new JpaDaoImpl(PersistenceManager.getEntityManager()); }
}

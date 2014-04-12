package factory;

import manager.TestPersistenceManager;
import persistence.*;

/**
 * User: Tom De Dobbeleer
 * Date: 2/7/14
 * Time: 7:01 PM
 * Remarks: none
 */
public class TestDaoFactory {
    private TestDaoFactory() {
    }

    public static JpaClientDao getClientDao() {
        return new JpaClientDao(TestPersistenceManager.getEntityManager());
    }

    public static JpaEmployeeDao getEmployeeDao() {
        return new JpaEmployeeDao(TestPersistenceManager.getEntityManager());
    }

    public static JpaServiceCallDao getServiceCallDao() {
        return new JpaServiceCallDao(TestPersistenceManager.getEntityManager());
    }

    public static JpaContactTypeDao getContactTypeDao() {
        return new JpaContactTypeDao(TestPersistenceManager.getEntityManager());
    }

    public static JpaRoleMappingDao getRoleMappingDao() {
        return new JpaRoleMappingDao(TestPersistenceManager.getEntityManager());
    }
}


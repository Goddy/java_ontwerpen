package persistence;

import javax.persistence.EntityManager;

/**
 * User: Tom De Dobbeleer
 * Date: 2/7/14
 * Time: 7:01 PM
 * Remarks: none
 */
public class DaoFactory {
    private DaoFactory() {
    }

    public static JpaClientDao getClientDao() {
        return new JpaClientDao(getEntityManager());
    }

    public static JpaEmployeeDao getEmployeeDao() {
        return new JpaEmployeeDao(getEntityManager());
    }

    public static JpaServiceCallDao getServiceCallDao() {
        return new JpaServiceCallDao(getEntityManager());
    }

    public static JpaContactTypeDao getContactTypeDao() {
        return new JpaContactTypeDao(getEntityManager());
    }

    public static JpaRoleDao getRoleDao() {
        return new JpaRoleDao(getEntityManager());
    }

    public static JpaRoleMappingDao getRoleMappingDao() {
        return new JpaRoleMappingDao(getEntityManager());
    }

    private static EntityManager getEntityManager() {
        return PersistenceManager.getEntityManager();
    }
}


package general;

import factory.TestDaoFactory;
import manager.TestPersistenceManager;
import org.junit.BeforeClass;
import persistence.ClientDao;
import persistence.ContactTypeDao;
import persistence.EmployeeDao;
import persistence.ServiceCallDao;

/**
 * Created by u0090265 on 3/28/14.
 */
public abstract class AbstractTest {
    protected static  ServiceCallDao serviceCallDao;
    protected static EmployeeDao employeeDao;
    protected static ClientDao clientDao;
    protected static ContactTypeDao contactTypeDao;

    /**
     * Make sure that each test is started with clean resources (so that no previous testdata will interfere)
     */
    @BeforeClass
    public static void initialize() {
        TestPersistenceManager.cleanResources();
        serviceCallDao = TestDaoFactory.getServiceCallDao();
        employeeDao = TestDaoFactory.getEmployeeDao();
        clientDao = TestDaoFactory.getClientDao();
        contactTypeDao = TestDaoFactory.getContactTypeDao();
    }
}

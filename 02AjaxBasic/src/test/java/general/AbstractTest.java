package general;

import factory.TestDaoFactory;
import persistence.ClientDao;
import persistence.ContactTypeDao;
import persistence.EmployeeDao;
import persistence.ServiceCallDao;

/**
 * Created by u0090265 on 3/28/14.
 */
public abstract class AbstractTest {
    protected ServiceCallDao serviceCallDao = TestDaoFactory.getServiceCallDao();
    protected EmployeeDao employeeDao = TestDaoFactory.getEmployeeDao();
    protected ClientDao clientDao = TestDaoFactory.getClientDao();
    protected ContactTypeDao contactTypeDao = TestDaoFactory.getContactTypeDao();
}

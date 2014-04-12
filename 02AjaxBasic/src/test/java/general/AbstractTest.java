package general;

import factory.TestDaoFactory;
import manager.TestPersistenceManager;
import org.junit.Before;
import org.junit.BeforeClass;
import persistence.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.reset;

/**
 * Created by u0090265 on 3/28/14.
 */
public abstract class AbstractTest {
    protected static  ServiceCallDao serviceCallDao;
    protected static EmployeeDao employeeDao;
    protected static ClientDao clientDao;
    protected static ContactTypeDao contactTypeDao;
    protected static RoleMappingDao roleMappingDao;
    protected static RoleDao roleDao;
    protected HttpServletRequest httpServletRequestMock = createStrictMock(HttpServletRequest.class);
    protected HttpServletResponse httpServletResponseMock = createStrictMock(HttpServletResponse.class);

    @Before
    public void setUp() {
        reset(httpServletRequestMock, httpServletResponseMock);
    }

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
        roleMappingDao = TestDaoFactory.getRoleMappingDao();
        roleDao = TestDaoFactory.getRoleDao();
    }
}

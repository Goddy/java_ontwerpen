package service;

import factory.TestObjectFactory;
import general.AbstractTest;
import model.Employee;
import org.junit.Before;
import org.junit.Test;
import utils.Constants;

import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by u0090265 on 3/29/14.
 */
public class EmployeeServiceImplTest extends AbstractTest {
    EmployeeService employeeService;

    @Before
    public void setUp() {
        employeeService = new EmployeeServiceImpl();
        employeeService.setEmployeeDao(employeeDao);
        employeeService.setRoleDao(roleDao);

    }

    @Test
    public void testGetAll() throws Exception {
        List<Employee> employees = employeeDao.getAll();
        for (int i = 0; i < 5; i++) {
            employees.add(TestObjectFactory.getTestEmployee(Constants.ROLETYPE_ADMIN));

        }
        employeeDao.createAll(employees);
        List<Employee> employeeResultList = employeeService.getAll();

        assertEquals(employeeResultList, employees);
    }

    @Test
    public void testRegisterEmployee() throws Exception {
        Employee employee = TestObjectFactory.getTestEmployee(Constants.ROLETYPE_ADMIN);

        expect(httpServletRequestMock.getParameter("firstName")).andReturn(employee.getGivenName());
        expect(httpServletRequestMock.getParameter("lastName")).andReturn(employee.getLastName());
        expect(httpServletRequestMock.getParameter("email")).andReturn(employee.getEmail());
        expect(httpServletRequestMock.getParameter("password")).andReturn("testpassword");
        expect(httpServletRequestMock.getParameter("role")).andReturn(employee.getRole().getRoleName());

        replay(httpServletRequestMock);

        Employee resultEmployee = employeeService.registerEmployee(httpServletRequestMock);

        assertNotNull(employeeDao.get(resultEmployee.getId()));
        assertEquals(resultEmployee.getUsername(), employee.getGivenName() + "." + employee.getLastName());
    }
}

package service;

import factory.TestObjectFactory;
import general.AbstractTest;
import model.Employee;
import model.RoleEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by u0090265 on 3/29/14.
 */
public class EmployeeServiceImplTest extends AbstractTest {
    @Test
    public void testGetAll() throws Exception {
        EmployeeService employeeService = new EmployeeServiceImpl();
        employeeService.setEmployeeDao(employeeDao);
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            employees.add(TestObjectFactory.getTestEmployee(RoleEnum.ADMIN));

        }
        //truncate table before equals
        employeeDao.createAll(employees);
        List<Employee> employeeResultList = employeeService.getAll();

        assertEquals(employeeResultList, employees);
    }
}

package service;

import model.Employee;
import persistence.DaoFactory;
import persistence.EmployeeDao;
import persistence.RoleDao;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by u0090265 on 3/9/14.
 */
public class EmployeeServiceImpl implements  EmployeeService {
    private EmployeeDao employeeDao;
    private RoleDao roleDao;

    public EmployeeServiceImpl() {
        setEmployeeDao(DaoFactory.getEmployeeDao());
        setRoleDao(DaoFactory.getRoleDao());

    }
    @Override
    public List<Employee> getAll() {
        return getEmployeeDao().getAll();
    }

    @Override
    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    @Override
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee registerEmployee(HttpServletRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Employee employee = new Employee();
        employee.setGivenName(request.getParameter("firstName"));
        employee.setLastName(request.getParameter("lastName"));
        employee.setEmail(request.getParameter("email"));
        employee.setAndEncryptPassword(request.getParameter("password"));
        employee.setRole(roleDao.getRoleByName(request.getParameter("role")));
        generateUserame(employee);

        employeeDao.create(employee);
        return employee;
    }

    private void generateUserame(Employee employee) {
        int counter = 0;
        String userName = employee.getGivenName() + "." + employee.getLastName();

        do {
            if (counter == 0) {
                usernameExists(userName, employee);
            }
            else {
                usernameExists(String.format("%s%d", userName, counter), employee);
            }
            counter++;

        } while (employee.getUsername() == null);
    }

    private boolean usernameExists(String username, Employee employee) {
        Employee resultEmpl = employeeDao.findEmployeeByUserName(username);
        if (resultEmpl == null) {
            employee.setUsername(username);
        }
        return employee.getUsername() == null;
    }

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}

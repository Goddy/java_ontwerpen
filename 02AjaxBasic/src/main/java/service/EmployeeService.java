package service;

import model.Employee;
import persistence.EmployeeDao;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by u0090265 on 3/9/14.
 */
public interface EmployeeService {
    List<Employee> getAll();

    EmployeeDao getEmployeeDao();

    void setEmployeeDao(EmployeeDao employeeDao);

    Employee registerEmployee(HttpServletRequest request) throws InvalidKeySpecException, NoSuchAlgorithmException;
}

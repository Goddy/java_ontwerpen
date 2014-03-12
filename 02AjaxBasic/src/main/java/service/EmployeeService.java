package service;

import model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by u0090265 on 3/9/14.
 */
public interface EmployeeService {
    List<Employee> getAll();
}

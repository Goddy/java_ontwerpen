package service;

import model.Employee;
import persistence.DaoFactory;
import persistence.EmployeeDao;

import java.util.List;

/**
 * Created by u0090265 on 3/9/14.
 */
public class EmployeeServiceImpl implements  EmployeeService {
    EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        employeeDao = DaoFactory.getEmployeeDao();
    }
    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }
}

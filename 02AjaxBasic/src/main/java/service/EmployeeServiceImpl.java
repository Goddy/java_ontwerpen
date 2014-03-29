package service;

import model.Employee;
import persistence.DaoFactory;
import persistence.EmployeeDao;

import java.util.List;

/**
 * Created by u0090265 on 3/9/14.
 */
public class EmployeeServiceImpl implements  EmployeeService {
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl() {
        setEmployeeDao(DaoFactory.getEmployeeDao());
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
}

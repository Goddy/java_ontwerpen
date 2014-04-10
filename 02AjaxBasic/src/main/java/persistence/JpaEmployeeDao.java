package persistence;

import model.Employee;

import javax.persistence.EntityManager;

/**
 * Created by u0090265 on 3/9/14.
 */
public class JpaEmployeeDao extends AbstractJpaDao<Employee> implements EmployeeDao {
    public JpaEmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Employee findEmployeeByUserName(String user) {
        return getSingleResultQuery("findEmployeeByUsername", getParameterMap("username", user));
    }
}

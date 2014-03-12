package persistence;

import model.Employee;
import org.hibernate.SessionFactory;

/**
 * Created by u0090265 on 3/9/14.
 */
public class HbnEmployeeDao extends AbstractHbnDao<Employee> implements EmployeeDao {
    public HbnEmployeeDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

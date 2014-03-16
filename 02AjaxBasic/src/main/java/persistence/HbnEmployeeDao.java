package persistence;

import model.ContactType;
import model.Employee;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by u0090265 on 3/9/14.
 */
public class HbnEmployeeDao extends AbstractHbnDao<Employee> implements EmployeeDao {
    public HbnEmployeeDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Employee getEmployee(Long id) {
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            Employee employee = super.get(id);
            tx.commit();

            return employee;
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            getSession().close();
        }
    }
}

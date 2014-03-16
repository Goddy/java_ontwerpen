package persistence;

import model.Client;
import model.ServiceCall;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by u0090265 on 3/12/14.
 */
public class HbnServiceCallDao extends AbstractHbnDao<ServiceCall> implements ServiceCallDao {
    public HbnServiceCallDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
     public void registerServiceCall(ServiceCall serviceCall) {
        Transaction tx = null;

        try {
            tx = getSession().beginTransaction();
            super.create(serviceCall);
            tx.commit();
        }
        catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e; // or display error message
        }
        finally {
            getSession().close();
        }

    }

    @Override
    public List<ServiceCall> getServiceCalls(Client client) {
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            Query q = getSession().getNamedQuery("findServiceCallsForClient");
            q.setParameter("client", client);
            List<ServiceCall> serviceCalls= (List<ServiceCall>)q.list();
            return serviceCalls;
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

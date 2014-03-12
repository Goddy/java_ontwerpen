package persistence;

import model.ServiceCall;
import org.hibernate.SessionFactory;

/**
 * Created by u0090265 on 3/12/14.
 */
public class HbnServiceCallDao extends AbstractHbnDao<ServiceCall> implements ServiceCallDao {
    public HbnServiceCallDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
     public void registerServiceCall(ServiceCall serviceCall) {
        super.create(serviceCall);
    }
}

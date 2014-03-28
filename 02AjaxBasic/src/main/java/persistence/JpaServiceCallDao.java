package persistence;

import model.Client;
import model.ServiceCall;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by u0090265 on 3/12/14.
 */
public class JpaServiceCallDao extends AbstractJpaDao<ServiceCall> implements ServiceCallDao {
    public JpaServiceCallDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<ServiceCall> getServiceCallsForClient(Client client) {
        return getMultipleResultQuery("findServiceCallsForClient", getParameterMap("client", client));
    }
}

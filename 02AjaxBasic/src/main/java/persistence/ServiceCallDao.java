package persistence;

import model.Client;
import model.ServiceCall;

import java.util.List;

/**
 * Created by u0090265 on 3/12/14.
 */
public interface ServiceCallDao extends Dao<ServiceCall> {
    List<ServiceCall> getServiceCallsForClient(Client client);
}

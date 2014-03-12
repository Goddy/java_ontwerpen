package persistence;

import model.ServiceCall;

/**
 * Created by u0090265 on 3/12/14.
 */
public interface ServiceCallDao extends Dao<ServiceCall> {
    void registerServiceCall(ServiceCall serviceCall);
}

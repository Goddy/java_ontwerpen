package service;

import model.Client;
import model.ServiceCall;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by u0090265 on 3/12/14.
 */
public interface ServiceCallService {
    ServiceCall getServiceCallById(String id);

    void registerServiceCall(HttpServletRequest request);

    List<ServiceCall> getServiceCallForClient(Client client);

    List<ServiceCall> getAllServiceCalls();

    void changeServiceCall(HttpServletRequest request);
}

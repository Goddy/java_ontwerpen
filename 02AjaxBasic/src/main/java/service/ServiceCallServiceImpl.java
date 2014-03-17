package service;

import model.Client;
import model.ServiceCall;
import persistence.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by u0090265 on 3/12/14.
 */
public class ServiceCallServiceImpl implements ServiceCallService {
    ServiceCallDao serviceCallDao;
    ClientDao clientDao;
    EmployeeDao employeeDao;
    HbnDaoImpl hbnDao; ;

    public ServiceCallServiceImpl() {
        serviceCallDao = DaoFactory.getServiceCallDao();
        clientDao = DaoFactory.getClientDao();
        employeeDao = DaoFactory.getEmployeeDao();
        hbnDao = DaoFactory.getHbnDao();

    }
    @Override
    public ServiceCall getServiceCallById(String id) {
        return serviceCallDao.getServiceCallById(Long.parseLong(id));
    }

    @Override
    public void registerServiceCall(HttpServletRequest request) {
        serviceCallDao.registerServiceCall(getServiceCallFromRequest(request));
    }

    @Override
    public List<ServiceCall> getServiceCallForClient(Client client) {
        return serviceCallDao.getServiceCalls(client);
    }

    @Override
    public List<ServiceCall> getAllServiceCalls() {
        return serviceCallDao.getAll();
    }

    @Override
    public void changeServiceCall(HttpServletRequest request) {
        ServiceCall serviceCall = getServiceCallFromRequest(request);
        serviceCall.setId(Long.parseLong(request.getParameter("serviceCallId")));
        serviceCallDao.update(serviceCall);
    }


    private ServiceCall getServiceCallFromRequest(HttpServletRequest request) {
        ServiceCall serviceCall = new ServiceCall();
        serviceCall.setDescription(request.getParameter("description"));
        serviceCall.setClient(clientDao.findClientById(Long.parseLong(request.getParameter("clientId"))));
        serviceCall.setShortDescription(request.getParameter("shortDescription"));
        serviceCall.setEmployee(employeeDao.getEmployee(Long.parseLong(request.getParameter("employeeId"))));
        return serviceCall;
    }
}

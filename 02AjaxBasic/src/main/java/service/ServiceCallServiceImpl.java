package service;

import model.Client;
import model.ServiceCall;
import persistence.ClientDao;
import persistence.DaoFactory;
import persistence.EmployeeDao;
import persistence.ServiceCallDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by u0090265 on 3/12/14.
 */
public class ServiceCallServiceImpl implements ServiceCallService {
    ServiceCallDao serviceCallDao;
    ClientDao clientDao;
    EmployeeDao employeeDao;

    public ServiceCallServiceImpl() {
        serviceCallDao = DaoFactory.getServiceCallDao();
        clientDao = DaoFactory.getClientDao();
        employeeDao = DaoFactory.getEmployeeDao();

    }
    @Override
    public ServiceCall getServiceCallById(String id) {
        return serviceCallDao.get(Long.parseLong(id));
    }

    @Override
    public void registerServiceCall(HttpServletRequest request) {
        serviceCallDao.create(createServiceCallFromRequest(request));
    }

    @Override
    public List<ServiceCall> getServiceCallForClient(Client client) {
        return serviceCallDao.getServiceCallsForClient(client);
    }

    @Override
    public List<ServiceCall> getAllServiceCalls() {
        return serviceCallDao.getAll();
    }

    @Override
    public void changeServiceCall(HttpServletRequest request) {
        updateServiceCallFromRequest(request);
    }


    private void updateServiceCallFromRequest(HttpServletRequest request) {
        ServiceCall serviceCall = serviceCallDao.get(Long.parseLong(request.getParameter("serviceCallId")));
        getServiceCallFromRequest(request, serviceCall);
    }

    private ServiceCall createServiceCallFromRequest(HttpServletRequest request) {
        return getServiceCallFromRequest(request, new ServiceCall());
    }

    private ServiceCall getServiceCallFromRequest(HttpServletRequest request, ServiceCall serviceCall) {
        serviceCall.setDescription(request.getParameter("description"));
        serviceCall.setClient(clientDao.get(Long.parseLong(request.getParameter("clientId"))));
        serviceCall.setShortDescription(request.getParameter("shortDescription"));
        serviceCall.setEmployee(employeeDao.get(Long.parseLong(request.getParameter("employeeId"))));
        return serviceCall;
    }
}

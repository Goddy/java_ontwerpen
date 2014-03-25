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
    JpaDaoImpl hbnDao;

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
        serviceCallDao.registerServiceCall(createServiceCallFromRequest(request));
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
        serviceCall.setClient(clientDao.findClientById(Long.parseLong(request.getParameter("clientId"))));
        serviceCall.setShortDescription(request.getParameter("shortDescription"));
        serviceCall.setEmployee(employeeDao.getEmployee(Long.parseLong(request.getParameter("employeeId"))));
        return serviceCall;
    }
}

package service;

import model.Employee;
import model.ServiceCall;
import persistence.ClientDao;
import persistence.DaoFactory;
import persistence.EmployeeDao;
import persistence.ServiceCallDao;

import javax.servlet.http.HttpServletRequest;

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
    public void registerServiceCall(HttpServletRequest request) {
        serviceCallDao.registerServiceCall(getServiceCallFromRequest(request));
    }

    private ServiceCall getServiceCallFromRequest(HttpServletRequest request) {
        ServiceCall serviceCall = new ServiceCall();
        serviceCall.setDescription(request.getAttribute("description").toString());
        serviceCall.setClient(clientDao.findClientById(request.getAttribute("clientId").toString()));
        serviceCall.setShortDescription(request.getAttribute("shortDescription").toString());
        serviceCall.setEmployee(employeeDao.get(request.getAttribute("employeeId").toString()));
        return serviceCall;
    }
}

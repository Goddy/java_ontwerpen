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
    public void registerServiceCall(HttpServletRequest request) {
        serviceCallDao.registerServiceCall(getServiceCallFromRequest(request));
    }

    @Override
    public List<ServiceCall> getServiceCallForClient(Client client) {
        return serviceCallDao.getServiceCalls(client);
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

package service;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 8:18 PM
 * Remarks: none
 */
public class ServiceFactory {
    public static ClientService getClientService() {return new ClientServiceImpl(); }
    public static EmployeeService getEmployeeService() {return new EmployeeServiceImpl(); }
    public static ServiceCallService getSerViceCallService() { return new ServiceCallServiceImpl(); }
}

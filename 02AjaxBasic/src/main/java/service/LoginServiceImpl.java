package service;

import exceptions.WrongPasswordOrUserNameException;
import model.Employee;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by u0090265 on 4/3/14.
 */
public class LoginServiceImpl implements LoginService {
    AuthenticationService authenticationService = ServiceFactory.getAuthenticationService();

    @Override
    public void login(HttpServletRequest request) throws WrongPasswordOrUserNameException {
        Employee authenticatedEmployee = authenticationService.authenticate(request.getParameter("username"), request.getParameter("password"));
        if (authenticatedEmployee != null) {
            request.getSession().setAttribute("employee", authenticatedEmployee);
        } else {
            throw new WrongPasswordOrUserNameException("Verkeerde gebruikersnaam/wachtwoord combinatie");
        }
    }
}

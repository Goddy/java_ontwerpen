package service;

import exceptions.WrongPasswordException;
import model.Employee;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by u0090265 on 4/3/14.
 */
public class LoginServiceImpl implements LoginService {
    AuthenticationService authenticationService = ServiceFactory.getAuthenticationService();

    @Override
    public void login(HttpServletRequest request) throws WrongPasswordException {
        Employee authenticatedEmployee = authenticationService.authenticate(request.getParameter("name"), request.getParameter("password"));
        if (authenticatedEmployee != null) {
            request.setAttribute("employee", authenticatedEmployee);
        }
        else {
            throw new WrongPasswordException("Verkeerd wachtwoord");
        }
    }
}

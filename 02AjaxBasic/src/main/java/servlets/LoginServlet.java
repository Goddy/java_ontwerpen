package servlets;

import exceptions.WrongPasswordException;
import service.LoginService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.LANDING_LOGIN;

/**
 * Created by u0090265 on 3/31/14.
 */

@WebServlet("/login")
public class LoginServlet extends MainServlet {
    LoginService loginService = ServiceFactory.getLoginService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
         getPage(request, response, LANDING_LOGIN);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            loginService.login(request);
            getPage(request, response, LANDING_LOGIN);
        }
        catch (WrongPasswordException e) {
            setErrorMsg(request, e.getMessage());
        }

    }
}
package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.LANDING_REGISTER_EMPLOYEE;

/**
 * Created by u0090265 on 4/9/14.
 */
public class RegisterEmployee extends MainServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getPage(request, response, LANDING_REGISTER_EMPLOYEE);
    }
}

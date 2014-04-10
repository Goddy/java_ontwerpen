package servlets;

import model.Employee;
import model.RoleEnum;
import service.EmployeeService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static utils.Constants.LANDING_REGISTER_EMPLOYEE;
import static utils.Constants.RESULT_UNKNOWN_ERROR;

/**
 * Created by u0090265 on 4/9/14.
 */
@WebServlet("/registerEmployee.html")
public class RegisterEmployeeServlet extends MainServlet {
    EmployeeService employeeService = ServiceFactory.getEmployeeService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Employee employee = employeeService.registerEmployee(request);
            setSuccessMsg(request, String.format("Registratie gelukt, de username voor de gebruiker is %s", employee.getUsername()));
        } catch (InvalidKeySpecException e) {
            setErrorMsg(request, String.format("Wachtwoord kon niet gegenereerd worden:\n%s", e.getMessage()));
        } catch (NoSuchAlgorithmException e) {
            setErrorMsg(request, String.format("Wachtwoord kon niet gegenereerd worden:\n%s", e.getMessage()));
        } catch (Exception e) {
            setErrorMsg(request, RESULT_UNKNOWN_ERROR);
        }

        doGet(request, response);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("roles", RoleEnum.values());
        getPage(request, response, LANDING_REGISTER_EMPLOYEE);
    }
}

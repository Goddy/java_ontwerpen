package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;
import service.EmployeeService;
import service.ServiceCallService;
import service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.*;

/**
 * Created by u0090265 on 3/9/14.
 */
@WebServlet("/registerServiceCall.html")
public class RegisterServiceCallServlet extends MainServlet {

    private ClientService clientService;
    private EmployeeService employeeService;
    private ServiceCallService serviceCallService;
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceCallServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug(request.toString());
        try {
            serviceCallService = ServiceFactory.getSerViceCallService();
            serviceCallService.registerServiceCall(request);
            request.setAttribute("resultDiv", "successBox");
            request.setAttribute("result", RESULT_SC_ADDED);
        }
        catch (Exception e) {
            request.setAttribute("resultDiv", "errorBox");
            request.setAttribute("result", RESULT_UNKNOWN_ERROR );
        }

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_SERVICECALL);
        dispatcher.forward(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("clientId");
        if (id.equals("") || id == null) {
            errorPage(request, response, RESULT_ID_NOT_SPECIFIED);
        }
        else {
            clientService = ServiceFactory.getClientService();
            employeeService = ServiceFactory.getEmployeeService();
            request.setAttribute("employees", employeeService.getAll());
            request.setAttribute("clientId", id);
            request.setAttribute("buttonAction" , "/registerServiceCall.html");

            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher(LANDING_REGISTER_SERVICECALL);
            dispatcher.forward(request, response);
        }
    }
}

package servlets;

import model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;
import service.EmployeeService;
import service.ServiceCallService;
import service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.*;

/**
 * Created by u0090265 on 3/9/14.
 */
@WebServlet("/registerServiceRequest")
public class RegisterServiceCall extends HttpServlet {

    private static final String LANDING_REGISTER_REQUEST = "jsp/registerServiceCall.jsp";
    private ClientService clientService;
    private EmployeeService employeeService;
    private ServiceCallService serviceCallService;
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

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
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_REQUEST);
        dispatcher.forward(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getAttribute("clientId").toString();
        if (id == "" || id == null) {
            request.setAttribute("resultDiv", "errorBox");
            request.setAttribute("result", RESULT_ID_NOT_SPECIFIED );
        }
        else {
            clientService = ServiceFactory.getClientService();
            Client client = clientService.getClientById(id);
            employeeService = ServiceFactory.getEmployeeService();
            request.setAttribute("employees", employeeService.getAll());
            request.setAttribute("clientId", client);
        }

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_REQUEST);
        dispatcher.forward(request, response);
    }
}

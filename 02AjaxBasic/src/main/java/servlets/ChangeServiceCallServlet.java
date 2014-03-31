package servlets;

import model.ServiceCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Created by u0090265 on 3/16/14.
 */
@WebServlet("/changeServiceCall")
public class ChangeServiceCallServlet extends MainServlet {

    private static final String LANDING_REGISTER_REQUEST = "jsp/registerServiceCall.jsp";
    private EmployeeService employeeService = ServiceFactory.getEmployeeService();
    private ServiceCallService serviceCallService = ServiceFactory.getSerViceCallService();
    private static final Logger logger = LoggerFactory.getLogger(ChangeServiceCallServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        getForm(id, request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug(request.toString());
        try {
            serviceCallService.changeServiceCall(request);
            request.setAttribute("resultDiv", "successBox");
            request.setAttribute("result", RESULT_SC_CHANGED);

        }
        catch (Exception e) {
            request.setAttribute("resultDiv", "errorBox");
            request.setAttribute("result", RESULT_UNKNOWN_ERROR );
        }

        getForm(request.getParameter("serviceCallId"), request, response);
    }

    private void getForm(String id, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (id == "" || id == null) {
            errorPage(request, response, RESULT_ID_NOT_SPECIFIED);
        }
        else {
            ServiceCall serviceCall = serviceCallService.getServiceCallById(id);
            request.setAttribute("serviceCallId", id);
            request.setAttribute("description", serviceCall.getDescription());
            request.setAttribute("shortDescription", serviceCall.getShortDescription());
            request.setAttribute("employee", serviceCall.getEmployee());
            request.setAttribute("employees", employeeService.getAll());
            request.setAttribute("clientId", serviceCall.getClient().getId());
            request.setAttribute("buttonAction" , "/changeServiceCall");

            RequestDispatcher dispatcher;
            dispatcher = request.getRequestDispatcher(LANDING_REGISTER_REQUEST);
            dispatcher.forward(request, response);
        }
    }
}

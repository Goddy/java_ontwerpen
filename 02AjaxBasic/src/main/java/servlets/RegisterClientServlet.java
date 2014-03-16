package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;
import service.ServiceFactory;

import static utils.Constants.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:09 PM
 * Remarks: none
 */

@WebServlet("/registerClient")
public class RegisterClientServlet extends HttpServlet {

    private static final String LANDING_REGISTER_CLIENT = "jsp/registerClient.jsp";
    private ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(RegisterClientServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug(request.toString());
        try {
            clientService = ServiceFactory.getClientService();
            clientService.registerClient(request);
            request.setAttribute("resultDiv", "successBox");
            request.setAttribute("result", RESULT_CLIENT_ADDED );
        }
        //todo: Specific exception handling
        catch (Exception e) {
            request.setAttribute("resultDiv", "errorBox");
            request.setAttribute("result", RESULT_UNKNOWN_ERROR );
        }

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_CLIENT);
        dispatcher.forward(request, response);
    }
}
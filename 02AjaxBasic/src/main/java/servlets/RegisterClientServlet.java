package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.*;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:09 PM
 * Remarks: none
 */

@WebServlet("/registerClient.html")
public class RegisterClientServlet extends MainServlet {

    private ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(RegisterClientServlet.class);
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getPage(request, response, LANDING_REGISTER_CLIENT);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug(request.toString());
        try {
            clientService = ServiceFactory.getClientService();
            clientService.registerClient(request);
            setSuccessMsg(request, RESULT_CLIENT_ADDED);
        }
        //todo: Specific exception handling
        catch (Exception e) {
            setErrorMsg(request, RESULT_UNKNOWN_ERROR);
        }
        doGet(request, response);
    }
}
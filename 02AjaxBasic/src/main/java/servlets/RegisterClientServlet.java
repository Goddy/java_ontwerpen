package servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;
import service.ClientServiceImpl;
import service.ServiceFactory;

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

    private static final String LANDING_REGISTER_CLIENT = "jsp/register.jsp";
    private ClientService registerClientService;
    private static final Logger logger = LoggerFactory.getLogger(ClientService.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug("Get operation on RegisterClient");
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_CLIENT);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        logger.debug(request.toString());
        registerClientService = ServiceFactory.getClientService();
        registerClientService.registerClient(request);
        request.setAttribute("result", "success");
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_CLIENT);
        dispatcher.forward(request, response);
    }


}
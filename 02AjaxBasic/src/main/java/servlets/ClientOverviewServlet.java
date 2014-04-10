package servlets;

import model.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.LANDING_CLIENT_OVERVIEW;

/**
 * Created by u0090265 on 3/16/14.
 */
@WebServlet("/clientOverview.html")
public class ClientOverviewServlet extends MainServlet{
    private ClientService clientService;
    private static final Logger logger = LoggerFactory.getLogger(ClientOverviewServlet.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        if (id == null || id == "") {
            errorPage(request,response, "Geen klantennummer gevonden in request");
        }
        else {
            clientService = ServiceFactory.getClientService();
            Client client = clientService.getClientById(id);
            request.setAttribute("client", client);
            getPage(request, response, LANDING_CLIENT_OVERVIEW);
        }
    }
}

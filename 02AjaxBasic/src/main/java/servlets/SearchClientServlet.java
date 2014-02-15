package servlets;

import model.Client;
import service.ClientService;
import service.ServiceFactory;
import utils.HtmlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static utils.Constants.*;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 8:09 PM
 * Remarks: none
 */
@WebServlet("/searchClient")
public class SearchClientServlet extends HttpServlet {

    ClientService clientService = ServiceFactory.getClientService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        String type = request.getParameter("type");
        String search = request.getParameter("search");
        String message;

        List<Client> clientList = clientService.searchForClient(search, type);

        if (clientList != null) {
            message = HtmlHelper.ClientListToTable(clientList);
        }
        else {
            message = RESULT_NO_RESULTS;
        }

        PrintWriter out = response.getWriter();
        out.print(message);
    }
}

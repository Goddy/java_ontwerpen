package servlets;

import service.ClientService;
import service.ClientServiceImpl;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * User: Tom De Dobbeleer
 * Date: 2/11/14
 * Time: 8:09 PM
 * Remarks: none
 */
@WebServlet("/searchClient")
public class SearchClientServlet {

    ClientService clientService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        clientService = ServiceFactory.getClientService();
        clientService.searchForClient(request.getParameter("term"));

        PrintWriter out = response.getWriter();
        Date currentTime = new Date();
        String message = String.format("It is now %tr on %tD.", currentTime, currentTime);
        out.print(message);
    }
}

package servlets;

import model.Address;
import model.Client;

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

@WebServlet("/register")
public class RegisterClientServlet extends HttpServlet {

    private static final String LANDING_REGISTER_CLIENT = "/WEB-INF/clients/register.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_CLIENT);
        dispatcher.forward(request, response);
    }

    public void getClientFromRequest(HttpServletRequest request) {
        Client client = new Client();
        Address address = new Address();
        address.setCity(request.getParameter("city"));
        address.setNumber(request.getParameter("number"));

    }
}
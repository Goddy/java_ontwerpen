package servlets;

import model.Address;
import model.AddressType;
import model.Client;
import service.RegisterClientService;
import service.RegisterClientServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Tom De Dobbeleer
 * Date: 2/5/14
 * Time: 4:09 PM
 * Remarks: none
 */

@WebServlet("/registerClient")
public class RegisterClientServlet extends HttpServlet {

    private static final String LANDING_REGISTER_CLIENT = "jsp/register.jsp";
    private RegisterClientService registerClientService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LANDING_REGISTER_CLIENT);

        registerClientService = new RegisterClientServiceImpl();
        registerClientService.registerClient(getClientFromRequest(request), getAddressFromRequest(request));

        request.setAttribute("result", "success");
        dispatcher.forward(request, response);
    }

    public Client getClientFromRequest(HttpServletRequest request) {
        Client client = new Client();
        client.setName(request.getParameter("name"));
        client.setPrimaryEmail(request.getParameter("email"));
        client.setPrimaryPhone(request.getParameter("telNr"));
        client.setVat(request.getParameter("vat"));

        return client;
    }

    public Address getAddressFromRequest(HttpServletRequest request) {
        Address address = new Address();
        AddressType addressType = registerClientService.getAddressType(Long.parseLong("1"));
        address.setType(addressType);
        address.setCity(request.getParameter("city"));
        address.setNumber(Integer.parseInt(request.getParameter("number")));
        address.setStreet(request.getParameter("street"));
        address.setCountry(request.getParameter("country"));
        address.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
        return address;
    }
}
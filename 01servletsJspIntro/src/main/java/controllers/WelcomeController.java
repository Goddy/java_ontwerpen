package controllers;

import utils.Constants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Tom De Dobbeleer
 * Date: 1/27/14
 * Time: 3:40 PM
 * Remarks: none
 */

@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        RequestDispatcher dispatcher;

        if (name != "") {
            request.setAttribute("name", name);
            dispatcher = request.getRequestDispatcher(Constants.LANDING_WELCOME);
        }
        else {
            request.setAttribute("errorMessage",Constants.MSG_NO_NAME_SPECIFIED);
            dispatcher = request.getRequestDispatcher(Constants.LANDING_ERROR);
        }

        dispatcher.forward(request, response);
    }
}

package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.LANDING_GENERAL_ERROR_PAGE;

/**
 * Created by u0090265 on 3/16/14.
 */
public abstract class MainServlet extends HttpServlet {

    protected void errorPage(HttpServletRequest request, HttpServletResponse response, String message) throws IOException, ServletException {
        request.setAttribute("title", "Error");
        request.setAttribute("reason", message);
        getPage(request, response, LANDING_GENERAL_ERROR_PAGE);
    }

    protected void getPage(HttpServletRequest request, HttpServletResponse response, String landing) throws IOException, ServletException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(landing);
        dispatcher.forward(request, response);
    }

    protected void setErrorMsg(HttpServletRequest request, String msg) {
        request.setAttribute("resultDiv", "alert alert-danger");
        request.setAttribute("result", msg);
    }

    protected void setSuccessMsg(HttpServletRequest request, String msg) {
        request.setAttribute("resultDiv", "alert alert-success");
        request.setAttribute("result", msg);
    }

    protected void setWarningMsg(HttpServletRequest request, String msg) {
        request.setAttribute("resultDiv", "alert alert-warning");
        request.setAttribute("result", msg);
    }
}

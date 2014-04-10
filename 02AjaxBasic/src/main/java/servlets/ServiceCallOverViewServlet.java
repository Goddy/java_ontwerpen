package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.LANDING_SERVICECALL_OVERVIEW;

/**
 * Created by u0090265 on 4/10/14.
 */

@WebServlet("/serviceCallOverview.html")
public class ServiceCallOverViewServlet extends MainServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getPage(request, response, LANDING_SERVICECALL_OVERVIEW);
    }
}

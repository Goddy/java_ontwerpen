package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.LANDING_GENERAL_ERROR_PAGE;

/**
 * Created by u0090265 on 4/11/14.
 */
@WebServlet("/notAuthorized.html")
public class NotAuthorizedServlet extends MainServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("title", "Toegang geweigerd");
        request.setAttribute("reason", "U bent niet geauthoriseerd voor deze bewerking");
        getPage(request, response, LANDING_GENERAL_ERROR_PAGE);
    }

}

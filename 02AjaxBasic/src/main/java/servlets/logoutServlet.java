package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.LANDING_LOGOUT;

/**
 * Created by u0090265 on 4/12/14.
 */
@WebServlet("/logout.html")
public class logoutServlet extends MainServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();
        getPage(request, response, LANDING_LOGOUT);
    }

}

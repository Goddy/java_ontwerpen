package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by u0090265 on 4/9/14.
 */
public class LoginInterceptorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        HttpSession session = req.getSession(false);

        if (!uri.endsWith("login.html")) {
            if(session != null) {
                if (session.getAttribute("employee") == null)
                    res.sendRedirect("/login.html");
                else
                    chain.doFilter(request, response);

            }
            else {
                res.sendRedirect("/login.html");
            }
        }
        else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}

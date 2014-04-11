package filter;

import model.Employee;
import model.RoleEnum;
import model.RoleMapping;
import persistence.DaoFactory;
import persistence.JpaRoleMappingDao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by u0090265 on 4/9/14.
 */
public class LoginInterceptorFilter implements Filter {
    JpaRoleMappingDao roleMappingDao = DaoFactory.getRoleMappingDao();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        HttpSession session = getSession(req);

        if (!getWhiteListMapping().contains(uri)) {
            if(session != null) {
                if (session.getAttribute("employee") == null)
                    res.sendRedirect("/login.html");
                else
                    checkRoleAndRedirect(req, res, (Employee) session.getAttribute("employee"), uri, chain);

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

    private void checkRoleAndRedirect(HttpServletRequest request, HttpServletResponse response, Employee employee, String uri, FilterChain chain) throws IOException, ServletException {
        RoleMapping roleMapping = roleMappingDao.getRole(uri);
        if (roleMapping != null && roleMapping.getRole() == RoleEnum.ADMIN) {
            if (employee.getRole().getRoleName() == RoleEnum.ADMIN) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect("/notAuhorized.html");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    private HttpSession getSession(HttpServletRequest request) {
        return request.getSession(false);
    }

    private List getWhiteListMapping() {
        ArrayList whiteList = new ArrayList<String>();
        for (RoleMapping rm : roleMappingDao.getServlets(RoleEnum.PUBLIC)) {
            whiteList.add(rm.getServlet());
        }
        return whiteList;
    }
}
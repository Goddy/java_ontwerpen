package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
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
        String url;
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            url = httpServletRequest.getRequestURI();
            String test = url;
            chain.doFilter(request, response);
            return;
        }

    }

    @Override
    public void destroy() {

    }
}

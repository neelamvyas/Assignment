package Filters;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class InputValidationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            ((HttpServletResponse) response).sendRedirect("error.html");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}

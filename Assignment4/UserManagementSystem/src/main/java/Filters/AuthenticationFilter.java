package Filters;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AuthenticationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            resp.sendRedirect("login.html");
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}
}

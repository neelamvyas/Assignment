import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logic to fetch all users and display
        List<User> users = UserDAO.getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userlist.jsp");
        dispatcher.forward(request, response);
    }
}

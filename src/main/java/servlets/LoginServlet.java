package servlets;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import persistence.dao.impl.FactoryDao;
import persistence.dao.impl.UserDaoImpl;
import persistence.entities.User;
import services.ServiceException;
import services.api.UserService;
import services.impl.FactoryService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by abalaev on 02.10.2016.
 */
@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(LoginServlet.class);
    UserService userService = FactoryService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login.equals("") || password.equals(""))
            request.getRequestDispatcher("login.jsp").forward(request, response);


        User user = null;
        try {
            user = userService.login(login,password);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (user != null) {
                LOG.info("Success login " + user.getFio() + " " + new Date());
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("/main");
            } else {
                PrintWriter out=response.getWriter();
                out.print("Sorry, username or password error!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                out.close();
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}

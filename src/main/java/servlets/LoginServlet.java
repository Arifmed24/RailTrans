package servlets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import persistence.entities.User;
import services.ServiceException;
import services.api.UserService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by abalaev on 02.10.2016.
 */
@WebServlet(name="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(LoginServlet.class);
    private UserService userService = FactoryService.getUserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (ValidationUtils.checkLogin(login)) {
            if (ValidationUtils.checkPassword(password)) {
                User user = null;
                try {
                    user = userService.findUserByLogin(login);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    LOG.error("Error ",e);
                }
                if (user != null) {
                    if (user.getPassword().equals(password)) {
                        LOG.info("Success login " + user.getFio() + " " + new Date());
                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        response.sendRedirect("/findway");
                    } else {
                        request.setAttribute("errorPas", "Wrong password");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errorLog", "Wrong login");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorPas", "Password can't be like this");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorLog", "Login can'be like this");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}

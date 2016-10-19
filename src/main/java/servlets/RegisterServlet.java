package servlets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import persistence.dao.impl.FactoryDao;
import persistence.dao.impl.UserDaoImpl;
import persistence.entities.RoleEnum;
import persistence.entities.User;
import services.api.UserService;
import services.impl.FactoryService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by abalaev on 02.10.2016.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/registration")
public class RegisterServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(RegisterServlet.class);
    UserService userService = FactoryService.getUserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullname");
        if (ValidationUtils.checkLogin(login)) {
            if (ValidationUtils.checkLogin(password)){
                if (ValidationUtils.checkFullName(fullName)) {
                    User newUser = new User();
                    newUser.setLogin(login);
                    newUser.setPassword(password);
                    newUser.setFio(fullName);
                    newUser.setRole(RoleEnum.USER);
                    if (userService.register(newUser)) {
                        LOG.info("New user " + newUser.getLogin() + " " + new Date());
                        request.getRequestDispatcher("/login").forward(request, response);
                    } else {
                        request.setAttribute("errorLog", "This user is registered yet");
                        request.getRequestDispatcher("/registration.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errorName", "Login can'be like this");
                    request.getRequestDispatcher("/registration.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorPass", "Password can'be like this");
                request.getRequestDispatcher("/registration.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorLog", "Please write first name and last name");
            request.getRequestDispatcher("/registration.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }
}

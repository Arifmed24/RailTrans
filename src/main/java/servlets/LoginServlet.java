package servlets;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import persistence.dao.impl.UserDaoImpl;
import persistence.entities.User;
import services.api.UserService;
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

   // private static final Logger LOG = LogManager.getLogger(LoginServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = new UserServiceImpl(new UserDaoImpl());

        try {
            User user = userService.login(login,password);


            if (user != null) {
//               Logging user login
//                LOG.info("Success login " + fio + " " + new Date());
                String fio = user.getFio();
                HttpSession session = request.getSession();
                session.setAttribute("user", fio);
                request.setAttribute("fio",fio);
                request.getRequestDispatcher("result.jsp").forward(request,response);
            }
            response.sendRedirect("/result");
        } catch (Exception e){
             request.setAttribute("info",e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}

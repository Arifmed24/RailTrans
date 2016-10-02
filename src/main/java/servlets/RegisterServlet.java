package servlets;

import persistence.dao.impl.UserDaoImpl;
import persistence.entities.User;
import services.api.UserService;
import services.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by abalaev on 02.10.2016.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String fio = request.getParameter("fio");
        User user = new User(login,password,fio);

        try {
            UserServiceImpl registerService = new UserServiceImpl(new UserDaoImpl());
            boolean result = registerService.register(user);
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registration Successful</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if(result){
                out.println("<h1>Thanks for Registering with us :</h1>");
                out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
            }else{
                out.println("<h1>Registration Failed</h1>");
                out.println("To try again<a href=register.jsp>Click here</a>");
            }
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

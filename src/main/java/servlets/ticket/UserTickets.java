package servlets.ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by abalaev on 26.10.2016.
 */
@WebServlet(name = "UserTickets", urlPatterns = "/userTickets")
public class UserTickets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "User Tickets");
        request.getRequestDispatcher("/pages/tickets/userTickets.jsp").forward(request,response);
    }
}

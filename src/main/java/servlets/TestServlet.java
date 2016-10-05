package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by abalaev on 03.10.2016.
 */
@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = null;
        response.setContentType("text/html");
        out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<head><title>DO you win</title></head>");
        out.println(request.getAttribute("result"));
        out.println("</body>");
        out.println("</html>");
    }
}

package servlets.route;

import servlets.ValidationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NumberOfElementsInRoute", urlPatterns = "/numberOfElements")
public class NumberOfElementsInRoute extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String elements = request.getParameter("elements");
        if (ValidationUtils.checkNumberOfStationsInRoute(elements)){
            int stationsInRoute = Integer.parseInt(elements);
            request.getSession().setAttribute("stationsInRoute", stationsInRoute);
            response.sendRedirect("/fillNewRoute");
        }else {
            request.setAttribute("error", "Please write number from 2 to 5");
            request.setAttribute("title", "Elements in route");
            request.getRequestDispatcher("/pages/admin/routes/numberOfElements.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Elements in route");
        request.getRequestDispatcher("/pages/admin/routes/numberOfElements.jsp").forward(request,response);
    }
}

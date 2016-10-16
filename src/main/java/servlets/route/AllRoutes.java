package servlets.route;

import services.api.RouteTimatablesService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by abalaev on 11.10.2016.
 */
@WebServlet(name = "AllRoutes",urlPatterns = "/routes")
public class AllRoutes extends HttpServlet {
        RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer, List<Integer>> routes = routeTimatablesService.getRoutes();
        request.setAttribute("routes", routes);
        request.setAttribute("title", "Routes");
        request.getRequestDispatcher("pages/routes/allRoutes.jsp").forward(request, response);
    }
}

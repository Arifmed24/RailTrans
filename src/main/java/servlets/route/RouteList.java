package servlets.route;

import org.apache.log4j.Logger;
import persistence.entities.Route;
import services.api.RouteService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RouteList",urlPatterns = "/routes")
public class RouteList extends HttpServlet {
    RouteService routeService = FactoryService.getRouteService();
    private static final Logger LOG = Logger.getLogger(RouteList.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Route> routes = routeService.getAllRoutes();
        if (routes.size() == 0) {
            LOG.info("No stations");
        }
        request.setAttribute("routes", routes);
        request.setAttribute("title","Routes");
        request.getRequestDispatcher("pages/admin/routes/allRoutes.jsp").forward(request, response);
    }
}

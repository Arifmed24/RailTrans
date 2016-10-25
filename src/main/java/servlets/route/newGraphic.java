package servlets.route;

import persistence.entities.Route;
import persistence.entities.RouteTimetables;
import services.api.RouteService;
import services.api.RouteTimatablesService;
import services.impl.FactoryService;
import servlets.ValidationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "newGraphic", urlPatterns = "/newgraphic")
public class newGraphic extends HttpServlet {
    private RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();
    private RouteService routeService = FactoryService.getRouteService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idRoute = Integer.parseInt(request.getParameter("idRoute"));
        Route route = routeService.readRoute(idRoute);
        List<RouteTimetables> routeTimetables = routeTimatablesService.createTemplateOfGraphic(route);
        request.getSession().setAttribute("routeTimetables",routeTimetables);
        request.getSession().setAttribute("route",route);
        request.setAttribute("title","Add graphic");
        request.getRequestDispatcher("/pages/admin/routes/addGraphic.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration enumeration = request.getParameterNames();
        List<Date> dates = new ArrayList<>();
        while (enumeration.hasMoreElements()){
            Object obj = enumeration.nextElement();
            String param = (String) obj;
            String value =  request.getParameter(param);

            if (ValidationUtils.checkDatetime(value)){
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dates.add(date);
            } else {
                request.setAttribute("error","Incorrect date");
                request.setAttribute("title","Add graphic");
                request.getRequestDispatcher("/pages/admin/routes/addGraphic.jsp").forward(request,response);
            }
        }
        Route route = (Route) request.getSession().getAttribute("route");
        List<RouteTimetables> routeTimetables;
        try {
            routeTimetables = routeTimatablesService.addDateInGraphic(dates,route);
            routeTimetables = routeTimatablesService.createGraphic(routeTimetables);
            request.getSession().removeAttribute("routeTimetables");
            request.getSession().removeAttribute("route");
            response.sendRedirect("/routes");
        } catch (Exception e) {
            e.getMessage();
            request.setAttribute("error",e.getMessage());
            request.setAttribute("title","Add graphic");
            request.getRequestDispatcher("/pages/admin/routes/addGraphic.jsp").forward(request,response);
        }

    }
}

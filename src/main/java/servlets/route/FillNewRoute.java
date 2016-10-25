package servlets.route;

import persistence.entities.Route;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import persistence.entities.Timetable;
import services.api.RouteTimatablesService;
import services.api.StationService;
import services.api.TimetableService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "FillNewRoute", urlPatterns = "/fillNewRoute")
public class FillNewRoute extends HttpServlet {
    private StationService stationService = FactoryService.getStationService();
    private TimetableService timetableService = FactoryService.getTimetableService();
    private RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration enumeration = request.getParameterNames();
        List<String> values = new ArrayList<>();
        while (enumeration.hasMoreElements()){
            Object obj = enumeration.nextElement();
            String param = (String) obj;
            String value =  request.getParameter(param);
            values.add(value);
        }
        List<String> stations = new ArrayList<>();
        for (int i=0;i<values.size()-2;i=i+3){
            stations.add(values.get(i));
        }
        for (int i=values.size()-3;i>=0;i--){
            if (i%3==0){
                values.remove(i);
            }
        }
        Route route = (Route) request.getSession().getAttribute("route");
        request.getSession().removeAttribute("stationsInRoute");

        try {
            List<Station> routeStations = stationService.checkStationsInRoute(route,stations);
            List<Timetable> routeTimetables = new ArrayList<>();
            for (int i=0;i<routeStations.size()-1;i++)
            {
                Timetable newTimetable = timetableService.readByStations(routeStations.get(i),routeStations.get(i+1));
                routeTimetables.add(newTimetable);
            }
            List<Date> routeDates = routeTimatablesService.checkDatesInRoute(values);
            for (int i=0;i<routeTimetables.size();i++){
                RouteTimetables newRoutetimetable = new RouteTimetables();
                newRoutetimetable.setNumberInRoute(i+1);
                newRoutetimetable.setLine(routeTimetables.get(i));
                newRoutetimetable.setRouteId(route);
                newRoutetimetable.setFreeSeats(route.getTrain().getSeats());
                newRoutetimetable.setDateDeparture(routeDates.get(i*2));
                newRoutetimetable.setDateArrival(routeDates.get(i*2+1));
                newRoutetimetable = routeTimatablesService.createRoutetimetable(newRoutetimetable);
            }
            request.removeAttribute("number");
            request.removeAttribute("route");
            request.removeAttribute("elements");
            request.removeAttribute("stations");
            response.sendRedirect("/routes");
        } catch (Exception e) {
            e.getMessage();
            request.setAttribute("error",e.getMessage());
            request.setAttribute("title","Fill new route");
            request.getRequestDispatcher("/pages/admin/routes/fillNewRoute.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberOfStations = (int) request.getSession().getAttribute("stationsInRoute");
        Route route = (Route) request.getSession().getAttribute("route");
        List<Station> stations = stationService.getAllStations();
        request.getSession().setAttribute("stations", stations);
        List<RouteTimetables> graphicOfRoute = new ArrayList<>();
        for (int i = 0; i < numberOfStations-1; i++) {
            RouteTimetables r = new RouteTimetables();
            graphicOfRoute.add(r);
        }
        request.setAttribute("title", "Fill new route");
        request.setAttribute("route", route);
        request.getSession().setAttribute("number", numberOfStations-1);
        request.getSession().setAttribute("elements", graphicOfRoute);
        request.getRequestDispatcher("/pages/admin/routes/fillNewRoute.jsp").forward(request,response);
    }
}

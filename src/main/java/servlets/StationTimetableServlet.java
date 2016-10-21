package servlets;

import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import services.api.RouteTimatablesService;
import services.api.StationService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 06.10.2016.
 */
@WebServlet(name = "StationTimetableServlet", urlPatterns = "/stationtime")
public class StationTimetableServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StationService stationService = FactoryService.getStationService();
        RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();

        String dateString = request.getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Station station = stationService.read(Integer.parseInt(request.getParameter("stationId")));
        Date date  = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<RouteTimetables> routeTimetables = routeTimatablesService.getTimetableStationArr(station,date);
        request.setAttribute("tables",routeTimetables);
        request.getRequestDispatcher("routeTimetables.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StationService stationService = FactoryService.getStationService();
                List<Station> stations = stationService.getAllStations();
                request.setAttribute("stations", stations);
                request.getRequestDispatcher("stations.jsp").forward(request,response);
    }
}

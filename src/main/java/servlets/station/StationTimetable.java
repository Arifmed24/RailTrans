package servlets.station;

import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import services.api.RouteTimatablesService;
import services.api.StationService;
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
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 08.10.2016.
 */
@WebServlet(name = "StationTimetable",urlPatterns = "/stationtimetable")
public class StationTimetable extends HttpServlet {

    StationService stationService = FactoryService.getStationService();
    RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateString = request.getParameter("date");
        String stationId = request.getParameter("stationId");

        if (ValidationUtils.checkDate(dateString)) {
            int id = Integer.parseInt(stationId);
            Station station = stationService.read(id);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = null;
            try {
                date = sdf.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<RouteTimetables> routeTimetablesArr = routeTimatablesService.getTimetableStationArr(station, date);
            List<RouteTimetables> routeTimetablesDep = routeTimatablesService.getTimetableStationDep(station, date);
            request.setAttribute("station", station.getStationName());
            request.setAttribute("date", date);
            request.setAttribute("tablesArr", routeTimetablesArr);
            request.setAttribute("tablesDep", routeTimetablesDep);
            request.setAttribute("title", "Station timetable");
            request.getSession().removeAttribute("nameStation");
            request.getSession().removeAttribute("idStation");
            request.getSession().removeAttribute("stations");
            request.getRequestDispatcher("pages/station/stationtimetable.jsp").forward(request, response);
        } else {
            request.setAttribute("title", "Station");
            request.setAttribute("error","Incorrect date");
            request.getRequestDispatcher("pages/station/chooseDateStation.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Station> stations = stationService.getAllStations();
        request.getSession().removeAttribute("nameStation");
        request.getSession().removeAttribute("idStation");
        request.getSession().removeAttribute("stations");
        request.getSession().setAttribute("nameStation",request.getParameter("nameStation"));
        request.getSession().setAttribute("idStation",request.getParameter("idStation"));
        request.getSession().setAttribute("stations", stations);
        request.setAttribute("title", "Station");
        request.getRequestDispatcher("pages/station/chooseDateStation.jsp").forward(request,response);
    }
}

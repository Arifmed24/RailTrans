package servlets.station;

import persistence.entities.Station;
import services.api.StationService;
import services.impl.FactoryService;
import servlets.ValidationUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StationCreate",urlPatterns = "/newstation")
public class StationCreate extends HttpServlet {
    StationService stationService = FactoryService.getStationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (ValidationUtils.checkStationName(name) && name.length()<50) {
            Station station = new Station();
            station.setStationName(name);
            stationService.createStation(station);
            request.getRequestDispatcher("/stations").forward(request, response);
        } else {
            request.setAttribute("error", "Wrong name");
            request.getRequestDispatcher("pages/admin/station/createStation.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title","Create station");
        request.getRequestDispatcher("pages/admin/station/createStation.jsp").forward(request, response);
    }
}

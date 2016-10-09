package servlets.station;

import persistence.entities.Station;
import services.api.StationService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by abalaev on 07.10.2016.
 */
@WebServlet(name = "StationCreate",urlPatterns = "/newstation")
public class StationCreate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        StationService stationService = FactoryService.getStationService();
        Station station = new Station();
        station.setStationName(name);
        stationService.createStation(station);
        request.setAttribute("title","Create station");
        request.getRequestDispatcher("/stations").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/station/createStation.jsp").forward(request, response);
    }
}
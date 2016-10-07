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
@WebServlet(name = "StationUpdate",urlPatterns = "/updatestation")
public class StationUpdate extends HttpServlet {

    StationService stationService = FactoryService.getStationService();
    Station station = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idStation = Integer.parseInt(request.getParameter("idStation"));
        station = stationService.read(idStation);
        request.setAttribute("station",station);
        request.setAttribute("title","Update Station");
        request.getRequestDispatcher("pages/station/updateStation.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("idStation");
        station.setStationName(name);
        stationService.updateStation(station);
        request.getRequestDispatcher("/stations").forward(request, response);
    }
}

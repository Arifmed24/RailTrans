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
import java.util.List;

@WebServlet(name = "AllStations",urlPatterns = "/stations")
public class AllStations extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StationService stationService = FactoryService.getStationService();
        List<Station> stations = stationService.getAllStations();
        request.setAttribute("stations", stations);
        request.setAttribute("title","Stations");
        request.getRequestDispatcher("pages/station/allStations.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

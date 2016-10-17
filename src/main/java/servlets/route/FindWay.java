package servlets.route;

import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import persistence.entities.Ticket;
import services.api.PassengerService;
import services.api.RouteTimatablesService;
import services.api.StationService;
import services.api.TicketService;
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
 * Created by abalaev on 12.10.2016.
 */
@WebServlet(name = "FindWay", urlPatterns = "/findway")
public class FindWay extends HttpServlet {
    StationService stationService = FactoryService.getStationService();
    RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();
    TicketService ticketService = FactoryService.getTicketService();
    PassengerService passengerService = FactoryService.getPassengerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String DepId = request.getParameter("stationDep");
        String ArrId = request.getParameter("stationArr");
        String dDep = request.getParameter("dateDep");
        String dArr = request.getParameter("dateArr");
        String search = request.getParameter("search");

        int stationDepId = Integer.parseInt(DepId);
        Station stationDep = stationService.read(stationDepId);

        int stationArrId = Integer.parseInt(ArrId);
        Station stationArr = stationService.read(stationArrId);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dateDep  = null;
        Date dateArr  = null;
        try {
            dateDep = sdf.parse(dDep);
            dateArr = sdf.parse(dArr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<List<RouteTimetables>> ways = routeTimatablesService.findWay(stationDep,stationArr,dateDep,dateArr);
        List<Ticket> tickets = ticketService.getTicketsFromRtLists(ways);
        request.getSession().setAttribute("ways", ways);
        request.setAttribute("tickets", tickets);
        request.setAttribute("title","Ways");
        if (search.equals("ways"))
            request.getRequestDispatcher("pages/routes/ways.jsp").forward(request,response);
        else
            request.getRequestDispatcher("pages/admin/routes/passengersOfWays.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Station> stations = stationService.getAllStations();
        request.setAttribute("stations", stations);
        request.setAttribute("title", "Find way");
        request.getRequestDispatcher("pages/routes/findWay.jsp").forward(request,response);
    }
}

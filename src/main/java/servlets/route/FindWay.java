package servlets.route;

import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import persistence.entities.Ticket;
import services.api.PassengerService;
import services.api.RouteTimatablesService;
import services.api.StationService;
import services.api.TicketService;
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

@WebServlet(name = "FindWay", urlPatterns = "/findway")
public class FindWay extends HttpServlet {
    private StationService stationService = FactoryService.getStationService();
    private RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();
    private TicketService ticketService = FactoryService.getTicketService();

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

        if(ValidationUtils.checkDate(dDep)) {
            if (ValidationUtils.checkDate(dArr)) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dateDep = null;
                Date dateArr = null;
                try {
                    dateDep = sdf.parse(dDep);
                    dateArr = sdf.parse(dArr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (search.equals("ways")) {
                    List<List<RouteTimetables>> ways = routeTimatablesService.findWay(stationDep, stationArr, dateDep, dateArr);
                    List<Ticket> tickets = ticketService.getTicketsFromRtLists(ways);
                    request.getSession().setAttribute("ways", ways);
                    request.getSession().setAttribute("tickets", tickets);
                    request.setAttribute("title", "Ways");
                    request.getSession().removeAttribute("stations");
                    if (ways.size()==0)
                        request.setAttribute("error","No variants for your request");
                    request.getRequestDispatcher("pages/routes/ways.jsp").forward(request, response);
                } else {
                    List<List<RouteTimetables>> ways = routeTimatablesService.findWay2(stationDep, stationArr, dateDep, dateArr);
                    List<Ticket> tickets = ticketService.getTicketsFromRtLists(ways);
                    request.getSession().setAttribute("ways", ways);
                    request.getSession().setAttribute("tickets", tickets);
                    request.setAttribute("title", "Ways");
                    request.getSession().removeAttribute("stations");
                    if (ways.size()==0)
                        request.setAttribute("error","No variants for your request");
                    request.getRequestDispatcher("pages/admin/routes/passengersOfWays.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("title", "Find way");
                request.setAttribute("errorA", "Incorrect date");
                request.getRequestDispatcher("pages/routes/findWay.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("title", "Find way");
            request.setAttribute("errorD", "Incorrect date");
            request.getRequestDispatcher("pages/routes/findWay.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Station> stations = stationService.getAllStations();
        request.getSession().setAttribute("stations", stations);
        request.setAttribute("title", "Find way");
        request.getRequestDispatcher("pages/routes/findWay.jsp").forward(request,response);
    }
}

package servlets.passenger;

import persistence.entities.Passenger;
import persistence.entities.RouteTimetables;
import services.api.PassengerService;
import services.impl.FactoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by abalaev on 14.10.2016.
 */
@WebServlet(name = "GetPassengers", urlPatterns = "/getpassengers")
public class GetPassengers extends HttpServlet {

    PassengerService passengerService = FactoryService.getPassengerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String indexS = request.getParameter("index");
        int i = Integer.parseInt(indexS);
        List<List<RouteTimetables>> ways  =(List<List<RouteTimetables>>) request.getSession().getAttribute("ways");
        List<RouteTimetables> way  = ways.get(i);
//        request.getSession().removeAttribute("ways");
        request.setAttribute("title", "Passengers");
        Set<Passenger> passengers = passengerService.getPassengersOfRoute(way);
        request.setAttribute("passengers",passengers);
        request.getRequestDispatcher("pages/passengers/autorizedPassangers.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

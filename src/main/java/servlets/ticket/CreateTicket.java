package servlets.ticket;

import persistence.entities.Passenger;
import persistence.entities.RouteTimetables;
import persistence.entities.Ticket;
import persistence.entities.User;
import services.api.PassengerService;
import services.api.RouteTimatablesService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abalaev on 12.10.2016.
 */
@WebServlet(name = "CreateTicket", urlPatterns = "/createticket")
public class CreateTicket extends HttpServlet {

    PassengerService passengerService = FactoryService.getPassengerService();
    TicketService ticketService = FactoryService.getTicketService();
    RouteTimatablesService routeTimatablesService =FactoryService.getRouteTimatablesService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first = request.getParameter("first");
        String last = request.getParameter("last");
        String b = request.getParameter("birth");
        //validation
        if (ValidationUtils.checkName(first)) {
            if (ValidationUtils.checkName(last)) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date birth = null;
                try {
                    birth = sdf.parse(b);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Passenger passenger = new Passenger();
                passenger.setBirth(birth);
                passenger.setFirstName(first);
                passenger.setLastName(last);
                Passenger ticketPassenger;
                //check passenger. if not exists - creates new one
                if (passengerService.isExists(passenger)) {
                    ticketPassenger = passengerService.getByNameAndBirth(passenger);
                } else {
                    ticketPassenger = passengerService.create(passenger);
                }

                Ticket t = (Ticket) request.getSession().getAttribute("ticket");
                List<RouteTimetables> way = (List<RouteTimetables>) request.getSession().getAttribute("way");
                Set<RouteTimetables> ticketWay = new HashSet<>(way);

                //check registration of this passenger in variant
                Set<Passenger> passengers = passengerService.getPassengersOfRoute(way);
                //flag
                boolean hasPassenger = false;
                //if this passenger exists in variant
               for (Passenger routePassenger : passengers) {
                    if (ticketPassenger.equals(routePassenger)) {
                        hasPassenger = true;
                    }
                }
                if (hasPassenger == false){
                        //final ticket
                        Ticket ticket = new Ticket();
                        ticket.setTicketPassenger(ticketPassenger);
                        ticket.setDepartureStation(t.getDepartureStation());
                        ticket.setDepartureDate(t.getDepartureDate());
                        ticket.setArrivalStation(t.getArrivalStation());
                        ticket.setArrivalDate(t.getArrivalDate());
                        ticket.setPrice(t.getPrice());
                        ticket.setTicketTrain(t.getTicketTrain());
                        ticket.setRouteTimetables(ticketWay);
                        ((User) request.getSession().getAttribute("user")).addTicket(ticket);
                        ticket = ticketService.createTicket(ticket);

                        for (RouteTimetables rt : way) {
                            rt.getTickets().add(ticket);
                            rt.setFreeSeats(rt.getFreeSeats() - 1);
                            routeTimatablesService.updateRouteTimetable(rt);
                        }
                        request.getSession().removeAttribute("way");
                        request.getSession().removeAttribute("ticket");
                        request.setAttribute("ticket", ticket);
                        request.setAttribute("title", "Ticket");
                        request.getRequestDispatcher("pages/tickets/viewTicket.jsp").forward(request, response);
                    } else {
                    request.setAttribute("error","This passenger is registered yet");
                    request.setAttribute("way",way);
                    request.setAttribute("ticket",t);
                    request.setAttribute("title", "Passenger");
                    request.getRequestDispatcher("pages/passengers/newPassenger.jsp").forward(request,response);
                }
            } else {
                List<RouteTimetables> way = (List<RouteTimetables>) request.getSession().getAttribute("way");
                request.setAttribute("errorL","Wrong last name");
                request.setAttribute("way",way);
                request.setAttribute("title", "Passenger");
                request.getRequestDispatcher("pages/passengers/newPassenger.jsp").forward(request,response);
            }
        } else {
            List<RouteTimetables> way = (List<RouteTimetables>) request.getSession().getAttribute("way");
            request.setAttribute("errorF","Wrong first name");
            request.setAttribute("way",way);
            request.setAttribute("title", "Passenger");
            request.getRequestDispatcher("pages/passengers/newPassenger.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String indexS = request.getParameter("index");
        int i = Integer.parseInt(indexS);
        List<List<RouteTimetables>> ways  =(List<List<RouteTimetables>>) request.getSession().getAttribute("ways");
        List<Ticket> tickets = (List<Ticket>) request.getSession().getAttribute("tickets");
        List<RouteTimetables> way  = ways.get(i);
        Ticket ticket = tickets.get(i);
        request.getSession().removeAttribute("ways");
        request.getSession().removeAttribute("tickets");
        request.getSession().setAttribute("way", way);
        request.getSession().setAttribute("ticket", ticket);
        request.setAttribute("title", "Passenger");
        request.getRequestDispatcher("pages/passengers/newPassenger.jsp").forward(request,response);
    }
}

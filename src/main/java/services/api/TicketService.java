package services.api;

import persistence.entities.RouteTimetables;
import persistence.entities.Ticket;

import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface TicketService {
    List<Ticket> getTicketsFromRtLists(List<List<RouteTimetables>> ways);
    Ticket createTicket(Ticket ticket);
    Ticket updateTicket(Ticket ticket);

}

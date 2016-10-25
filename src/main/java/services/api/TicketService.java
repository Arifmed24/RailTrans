package services.api;

import persistence.entities.RouteTimetables;
import persistence.entities.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getTicketsFromRtLists(List<List<RouteTimetables>> ways);
    Ticket createTicket(Ticket ticket);
}

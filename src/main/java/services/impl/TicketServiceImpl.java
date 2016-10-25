package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.TicketDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.RouteTimetables;
import persistence.entities.Ticket;
import services.api.TicketService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    private static final Logger LOG = Logger.getLogger(TicketServiceImpl.class);
    private TicketDao ticketDao = FactoryDao.getTicketDao();

    /**
     * get tickets of ways
     * @param ways  ways
     * @return      tickets
     */
    public List<Ticket> getTicketsFromRtLists(List<List<RouteTimetables>> ways) {
        LOG.info("finding tickets of ways");
        List<Ticket> tickets = new ArrayList<>();
        LOG.info("going through ways");
        for (List<RouteTimetables> variant: ways) {
            Ticket newTicket = new Ticket();
            newTicket.setTicketTrain(variant.get(0).getRouteId().getTrain());
            newTicket.setDepartureDate(variant.get(0).getDateDeparture());
            newTicket.setDepartureStation(variant.get(0).getLine().getStationDeparture());
            newTicket.setArrivalDate(variant.get(variant.size()-1).getDateArrival());
            newTicket.setArrivalStation(variant.get(variant.size()-1).getLine().getStationArrival());
            double price = 0;
            for (RouteTimetables aVariant : variant) {
                price += aVariant.getLine().getDistance() * 4;
            }
            BigDecimal b = new BigDecimal(price, MathContext.DECIMAL64);
            newTicket.setPrice(b);
            tickets.add(newTicket);
            LOG.info("ticket was added");
        }
        return tickets;
    }

    public Ticket createTicket(Ticket ticket) {
        Ticket result;
            result = ticketDao.create(ticket);
            LOG.info("ticket created {}", result);
        return result;
    }

}

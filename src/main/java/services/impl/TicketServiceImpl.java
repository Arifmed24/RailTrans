package services.impl;

import persistence.DaoException;
import persistence.dao.api.TicketDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.RouteTimetables;
import persistence.entities.Ticket;
import services.api.TicketService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abalaev on 07.10.2016.
 */
public class TicketServiceImpl implements TicketService {
    TicketDao ticketDao = FactoryDao.getTicketDao();

    @Override
    public List<Ticket> getTicketsFromRtLists(List<List<RouteTimetables>> ways) {
        List<Ticket> tickets = new ArrayList<>();
        for (List<RouteTimetables> vatiant: ways) {
            Ticket newTicket = new Ticket();
            newTicket.setTicketTrain(vatiant.get(0).getRouteId().getTrain());
            newTicket.setDepartureDate(vatiant.get(0).getDateDeparture());
            newTicket.setDepartureStation(vatiant.get(0).getLine().getStationDeparture());
            newTicket.setArrivalDate(vatiant.get(vatiant.size()-1).getDateArrival());
            newTicket.setArrivalStation(vatiant.get(vatiant.size()-1).getLine().getStationArrival());
            double price = 0;
            for (int i=0;i<vatiant.size();i++){
                price += vatiant.get(i).getLine().getDistance()*4;
            }
            BigDecimal b = new BigDecimal(price, MathContext.DECIMAL64);
            newTicket.setPrice(b);
            tickets.add(newTicket);
        }
        return tickets;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        Ticket result = null;
        try {
            result = ticketDao.create(ticket);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        Ticket result = null;
        try {
            result = ticketDao.update(ticket);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return result;
    }
}

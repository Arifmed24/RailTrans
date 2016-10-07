package services.impl;

import persistence.dao.api.TicketDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Ticket;
import services.api.TicketService;

/**
 * Created by abalaev on 07.10.2016.
 */
public class TicketServiceImpl implements TicketService {
    TicketDao ticketDao = FactoryDao.getTicketDao();
}

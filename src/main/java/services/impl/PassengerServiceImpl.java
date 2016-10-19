package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.PassengerDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Passenger;
import persistence.entities.RouteTimetables;
import persistence.entities.Ticket;
import services.api.PassengerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abalaev on 07.10.2016.
 */
public class PassengerServiceImpl implements PassengerService {
    private PassengerDao passengerDao = FactoryDao.getPassengerDao();
    private static final Logger LOG = Logger.getLogger(PassengerServiceImpl.class);
    @Override
    public boolean isExists(Passenger passenger) {
        int size = passengerDao.findPassenger(passenger.getFirstName(),passenger.getLastName(),passenger.getBirth()) .size();
        if (size>0){
            LOG.info("passenger exists");
            return true;
        }
        else {
            LOG.info("passenger doesn't exists");
            return false;
        }
    }

    @Override
    public Passenger create(Passenger passenger) {
        Passenger result = null;
            result = passengerDao.create(passenger);
            LOG.info("created passenger {}",result);
        return result;
    }

    @Override
    public Passenger getByNameAndBirth(Passenger passenger) {
        Passenger result;
        result = passengerDao.findPassenger(passenger.getFirstName(),passenger.getLastName(),passenger.getBirth()).get(0);
        LOG.info("passenger {} is found",result);
        return result;
    }

    @Override
    public Set<Passenger> getPassengersOfRoute(List<RouteTimetables> timetables) {
        Set<Passenger> result = new HashSet<>();
        for (RouteTimetables rt: timetables) {
            for (Ticket t :rt.getTickets()) {
                if (t.getTicketPassenger() != null) {
                    result.add(t.getTicketPassenger());
                }
            }
        }
        LOG.info("finding passengers of route");
        return result;
    }
}

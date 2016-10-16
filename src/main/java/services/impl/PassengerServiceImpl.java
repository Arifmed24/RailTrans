package services.impl;

import persistence.DaoException;
import persistence.dao.api.PassengerDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Passenger;
import persistence.entities.RouteTimetables;
import persistence.entities.Ticket;
import services.api.PassengerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abalaev on 07.10.2016.
 */
public class PassengerServiceImpl implements PassengerService {
    PassengerDao passengerDao = FactoryDao.getPassengerDao();

    @Override
    public boolean isExists(Passenger passenger) {

        int size = passengerDao.findPassenger(passenger.getFirstName(),passenger.getLastName(),passenger.getBirth()) .size();
        if (size>0){
            return true;
        }
        else
        return false;
    }

    @Override
    public Passenger create(Passenger passenger) {
        Passenger result = null;
        try {
            result = passengerDao.create(passenger);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Passenger getByNameAndBirth(Passenger passenger) {
        List<Passenger> result = null;
        result = passengerDao.findPassenger(passenger.getFirstName(),passenger.getLastName(),passenger.getBirth());
        return result.get(0);
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
        return result;
    }
}

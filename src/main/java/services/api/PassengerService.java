package services.api;

import persistence.entities.Passenger;
import persistence.entities.RouteTimetables;

import java.util.List;
import java.util.Set;

public interface PassengerService {
    boolean isExists(Passenger passenger);
    Passenger create(Passenger passenger);
    Passenger getByNameAndBirth(Passenger passenger);
    Set<Passenger> getPassengersOfRoute (List<RouteTimetables> timetables);
}

package persistence.dao.api;

import persistence.entities.Passenger;

import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface PassengerDao extends GenericDao<Passenger> {
    List<Passenger> findPassenger(String firstName, String lastName, Date birth);
}

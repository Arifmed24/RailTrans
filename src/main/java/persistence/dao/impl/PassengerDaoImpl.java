package persistence.dao.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.PassengerDao;
import persistence.entities.Passenger;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class PassengerDaoImpl extends GenericDaoImpl<Passenger> implements PassengerDao {

    private static final Logger LOG = Logger.getLogger(PassengerDaoImpl.class);

    /**
     * find passenger by name and birth
     * @param firstName first name
     * @param lastName  last name
     * @param birth     birth day
     * @return          passenger
     */
    public List<Passenger> findPassenger(String firstName, String lastName, Date birth) {
        List<Passenger> passengers = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Passenger> query;
            query = em.createNamedQuery("Passenger.getPassengers", Passenger.class);
            query.setParameter("first", firstName);
            query.setParameter("last", lastName);
            query.setParameter("b", birth, TemporalType.DATE);
            passengers = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOG.error("Error in finding Passenger by full name and birth");
        }
        return passengers;
    }
}


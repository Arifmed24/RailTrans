package persistence.dao.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.PassengerDao;
import persistence.entities.Passenger;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class PassengerDaoImpl extends GenericDaoImpl<Passenger> implements PassengerDao {

    private static final Logger LOG = Logger.getLogger(PassengerDaoImpl.class);

    @Override
    public List<Passenger> findPassenger(String firstName, String lastName, Date birth) {
        List<Passenger> passengers = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Passenger> query = null;
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


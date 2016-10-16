package persistence.dao.impl;

import persistence.DaoException;
import persistence.dao.api.PassengerDao;
import persistence.entities.Passenger;
import persistence.entities.RouteTimetables;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class PassengerDaoImpl extends GenericDaoImpl<Passenger> implements PassengerDao {

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
        }
        return passengers;
    }

//    @Override
//    public List<Passenger> getRoutePassengers(List<RouteTimetables> timetables) {
//        List<Passenger> result = null;
//        List<Integer> ids = new ArrayList<>();
//        for (RouteTimetables rt: timetables) {
//            ids.add(rt.getIdEvent());
//        }
//
//        try{
//            em.getTransaction().begin();
//            TypedQuery<Passenger> query = null;
//            query = em.createNamedQuery("Passenger.getRoutePassengers",Passenger.class);
//            query.setParameter("events",ids);
//            result = query.getResultList();
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//        }
//        return result;
//    }
}


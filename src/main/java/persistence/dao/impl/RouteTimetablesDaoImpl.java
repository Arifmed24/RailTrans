package persistence.dao.impl;

import persistence.dao.api.RouteTimetablesDao;
import persistence.entities.Route;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 05.10.2016.
 */
public class RouteTimetablesDaoImpl extends GenericDaoImpl<RouteTimetables> implements RouteTimetablesDao {
    @Override
    public List<RouteTimetables> getAll() {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query = null;
            query = em.createNamedQuery("RouteTimetables.getAll", RouteTimetables.class);
            result = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e)
        {
            em.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public List<RouteTimetables> getStationTimetableArr(Station station, Date dateBegin, Date dateEnd) {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query = null;
            query = em.createNamedQuery("RouteTimetables.getStationTimetableArr",RouteTimetables.class);
            query.setParameter("station", station);
            query.setParameter("date1", dateBegin);
            query.setParameter("date2", dateEnd);
            result = query.getResultList();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public List<RouteTimetables> getStationTimetableDep(Station station, Date dateBegin, Date dateEnd) {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query = null;
            query = em.createNamedQuery("RouteTimetables.getStationTimetableDep",RouteTimetables.class);
            query.setParameter("station", station);
            query.setParameter("date1", dateBegin);
            query.setParameter("date2", dateEnd);
            result = query.getResultList();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public List<RouteTimetables> getRoutes() {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query = null;
            query = em.createNamedQuery("RouteTimetables.getRoutes", RouteTimetables.class);
            result = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e)
        {
            em.getTransaction().rollback();
        }
        return result;
    }

    @Override
    public List<RouteTimetables> getRouteTimetableByRouteAndNumberInRoute(Route route, int number, Date dateBegin, Date dateEnd) {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query = null;
            query = em.createNamedQuery("RouteTimetables.getRouteTimetableByRouteAndNumberInRoute", RouteTimetables.class);
            query.setParameter("route", route);
            query.setParameter("number", number);
            query.setParameter("dateBegin", dateBegin, TemporalType.TIMESTAMP);
            query.setParameter("dateEnd", dateEnd, TemporalType.TIMESTAMP);
            result = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e)
        {
            em.getTransaction().rollback();
        }
        return result;
    }
}

package persistence.dao.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.RouteTimetablesDao;
import persistence.entities.Route;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;


public class RouteTimetablesDaoImpl extends GenericDaoImpl<RouteTimetables> implements RouteTimetablesDao {

    private static final Logger LOG = Logger.getLogger(RouteTimetablesDaoImpl.class);

    /**
     *  get list of all RouteTimetables
     * @return list of routeTimetables
     */
    public List<RouteTimetables> getAll() {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query;
            query = em.createNamedQuery("RouteTimetables.getAll", RouteTimetables.class);
            result = query.getResultList();
            LOG.info("get all route timetables");
            em.getTransaction().commit();
        } catch (Exception e)
        {
            em.getTransaction().rollback();
            LOG.error("Error in getting all routeTimetables ", e);
        }
        return result;
    }

    /**
     * get arrival timetable of station in interval
     * @param station       station
     * @param dateBegin     begin if interval
     * @param dateEnd       end of interval
     * @return              arrival timetable
     */
    public List<RouteTimetables> getStationTimetableArr(Station station, Date dateBegin, Date dateEnd) {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query;
            query = em.createNamedQuery("RouteTimetables.getStationTimetableArr",RouteTimetables.class);
            query.setParameter("station", station);
            query.setParameter("date1", dateBegin);
            query.setParameter("date2", dateEnd);
            result = query.getResultList();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            LOG.error("Error in getting station timetable", e);
        }
        return result;
    }

    /**
     * get departure timetable of station in interval
     * @param station       station
     * @param dateBegin     begin if interval
     * @param dateEnd       end of interval
     * @return              departure timetable
     */
    public List<RouteTimetables> getStationTimetableDep(Station station, Date dateBegin, Date dateEnd) {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query;
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

    /**
     * get all routes
     * @return      list of routes
     */
    public List<RouteTimetables> getRoutes() {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query;
            query = em.createNamedQuery("RouteTimetables.getRoutes", RouteTimetables.class);
            result = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e)
        {
            em.getTransaction().rollback();
        }
        return result;
    }

    /**
     * get routeTimetable by route and number in route in interval
     * @param route         route
     * @param number        number in route
     * @param dateBegin     begin of interval
     * @param dateEnd       end of interval
     * @return              list of routes
     */
    public List<RouteTimetables> getRouteTimetableByRouteAndNumberInRoute(Route route, int number, Date dateBegin, Date dateEnd) {
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query;
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

    /**
     * get list of routeTimetables by route
     * @param route     route
     * @return          route timetables (grouped by route and number in route)
     */
    public List<RouteTimetables> getListRtByRoute(Route route) {
        LOG.info("start getting list of route timetables by route ");
        List<RouteTimetables> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<RouteTimetables> query;
            query = em.createNamedQuery("RouteTimetables.getListRtByRoute",RouteTimetables.class);
            query.setParameter("route", route);
            result = query.getResultList();
            em.getTransaction().commit();
            LOG.info("finished getting list of route timetables by route");
        } catch (Exception e){
            LOG.error("error in getting list of route timetables by route", e);
            em.getTransaction().rollback();
        }
        return result;
    }
}

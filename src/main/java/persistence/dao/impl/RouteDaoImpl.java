package persistence.dao.impl;

import persistence.dao.api.RouteDao;
import persistence.entities.Route;
import persistence.entities.Timetable;

import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by abalaev on 30.09.2016.
 */
public class RouteDaoImpl extends GenericDaoImpl<Route> implements RouteDao {
//    @Override
//    public List<Timetable> findTimetablesOfRoute(int idRoute) {
//        List<Timetable> result = null;
//        TypedQuery<Timetable> query;
//        query = em.createNamedQuery("Route.findTimetablesByRoute", Route.class);
//        query.setParameter("id", idRoute);
//        return query.getResultList();
//    }
}

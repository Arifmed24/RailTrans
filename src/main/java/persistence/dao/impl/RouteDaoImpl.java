package persistence.dao.impl;

import persistence.dao.api.RouteDao;
import persistence.entities.Route;

import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by abalaev on 30.09.2016.
 */
public class RouteDaoImpl extends GenericDaoImpl<Route> implements RouteDao {
    /**
     * get list of all routes
     * @return  list of routes
     */
    public List<Route> getAll() {
        List<Route> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Route> query = null;
            query = em.createNamedQuery("Route.getAll",Route.class);
            result = query.getResultList();
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
        }
        return result;

    }
}

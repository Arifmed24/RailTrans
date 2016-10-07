package persistence.dao.impl;

import persistence.dao.api.RouteTimetablesDao;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;

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
}

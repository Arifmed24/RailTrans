package persistence.dao.impl;

import persistence.dao.api.StationDao;
import persistence.entities.Station;

import java.util.List;

import javax.persistence.TypedQuery;

public class StationDaoImpl extends GenericDaoImpl<Station> implements StationDao {
    /**
     * gel list of all stations
     * @return     list of stations
     */
    public List<Station> getAll() {
        List<Station> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Station> query;
            query = em.createNamedQuery("Station.getAll",Station.class);
            result = query.getResultList();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        return result;
    }
}

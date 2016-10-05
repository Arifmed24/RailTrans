package persistence.dao.impl;

import persistence.dao.api.StationDao;
import persistence.entities.Station;

import java.sql.SQLException;
import java.util.List;
//import org.apache.log4j.Logger;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * Created by abalaev on 28.09.2016.
 */
public class StationDaoImpl extends GenericDaoImpl<Station> implements StationDao {

    @Override
    public Station findStationByName(String stationName) {
        Query query = em.createNamedQuery("Station.findStationByName",Station.class);
        query.setParameter("stationName",stationName);
        return (Station) query.getSingleResult();
    }

    @Override
    public List<Station> getAll() {
        TypedQuery<Station> query = null;
        query = em.createNamedQuery("Station.getAll",Station.class);
        return query.getResultList();
    }
}

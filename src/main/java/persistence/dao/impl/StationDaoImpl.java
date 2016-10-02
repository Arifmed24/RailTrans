package persistence.dao.impl;

import persistence.dao.api.StationDao;
import persistence.entities.Station;

import java.sql.SQLException;
import java.util.List;
//import org.apache.log4j.Logger;

import javax.persistence.TypedQuery;

/**
 * Created by abalaev on 28.09.2016.
 */
public class StationDaoImpl extends GenericDaoImpl<Station> implements StationDao {

    /*private static final Logger LOG = Logger.getLogger(StationDaoImpl.class);

    @Override
    public List<Station> findAll() throws SQLException {
        try {
            TypedQuery<Station> query =
                    entityManager.createQuery("SELECT * from station");
            return query.getResultList();
        }catch (Exception e){
            LOG.error("Unexpected DB exception", e);
            throw  new SQLException(e);
        }
    }*/
}

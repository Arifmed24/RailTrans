package persistence.dao.api;

import persistence.entities.Station;

import java.util.List;

/**
 * Created by abalaev on 28.09.2016.
 */
public interface StationDao extends GenericDao<Station>{
    List<Station> getAll();
}

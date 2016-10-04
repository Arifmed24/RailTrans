package persistence.dao.api;

import persistence.entities.Station;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by abalaev on 28.09.2016.
 */
public interface StationDao extends GenericDao<Station>{
    Station findStationByName(String stationName);
}

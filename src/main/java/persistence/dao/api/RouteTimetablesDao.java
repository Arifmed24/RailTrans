package persistence.dao.api;

import persistence.entities.RouteTimetables;
import persistence.entities.Station;

import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 05.10.2016.
 */
public interface RouteTimetablesDao extends GenericDao<RouteTimetables> {

    List<RouteTimetables> getAll();
}

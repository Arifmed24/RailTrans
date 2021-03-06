package persistence.dao.api;

import persistence.entities.Station;
import persistence.entities.Timetable;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface TimetableDao extends GenericDao<Timetable> {
    Timetable readByStations (Station stationBegin, Station stationEnd);
}

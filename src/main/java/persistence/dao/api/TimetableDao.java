package persistence.dao.api;

import persistence.entities.Station;
import persistence.entities.Timetable;

import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface TimetableDao extends GenericDao<Timetable> {
    List<Timetable> getStationTimetable(Station station, Date date);
}

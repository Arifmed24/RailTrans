package services.api;

import persistence.entities.Route;
import persistence.entities.Station;
import persistence.entities.Timetable;

import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface TimetableService {
    List<Timetable> createTimetableList(List<Station> stations);
    List<Timetable> createTimetablesOfRoute (Route route, Timetable...timetables);
}

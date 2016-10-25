package services.api;

import persistence.entities.Station;
import persistence.entities.Timetable;

public interface TimetableService {
    Timetable readByStations (Station stationBegin, Station stationEnd) throws Exception;
}

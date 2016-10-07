package services.api;

import persistence.entities.Station;
import persistence.entities.Timetable;

import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 28.09.2016.
 */
public interface StationService {
    List<Station> getAllStations();
    Station read(int id);
    Station createStation(Station station);
    Station updateStation(Station station);
}

package services.api;

import persistence.entities.RouteTimetables;
import persistence.entities.Station;

import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 06.10.2016.
 */
public interface RouteTimatablesService {
    List<RouteTimetables> getTimetableStation(Station station, Date date);
}

package services.api;

import persistence.entities.RouteTimetables;
import persistence.entities.Station;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by abalaev on 06.10.2016.
 */
public interface RouteTimatablesService {
    List<RouteTimetables> getTimetableStationArr(Station station, Date date);
    List<RouteTimetables> getTimetableStationDep(Station station, Date date);
    Map<Integer,List<Integer>> getRoutes();
}

package services.api;

import persistence.entities.Route;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface RouteTimatablesService {
    RouteTimetables createRoutetimetable (RouteTimetables routeTimetables);
    List<RouteTimetables> getTimetableStationArr(Station station, Date date);
    List<RouteTimetables> getTimetableStationDep(Station station, Date date);
    Map<Integer,List<Integer>> getRoutes();
    List<List<RouteTimetables>> findWay(Station stationBegin, Station stationEnd, Date dateBegin, Date dateEnd);
    RouteTimetables updateRouteTimetable(RouteTimetables routeTimetables);
    List<RouteTimetables> createTemplateOfGraphic (Route route);
    List<RouteTimetables> addDateInGraphic (List<Date> dates, Route route) throws Exception;
    List<RouteTimetables> createGraphic (List<RouteTimetables> routeTimetables);
    List<Date> checkDatesInRoute (List<String> dates) throws Exception;
}

package services.impl;

import org.apache.commons.lang.time.DateUtils;
import persistence.dao.api.RouteTimetablesDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import services.api.RouteTimatablesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by abalaev on 06.10.2016.
 */
public class RouteTimetableServiceImpl implements RouteTimatablesService {

    RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();

    public List<RouteTimetables> getTimetableStationArr(Station station, Date date) {
        List<RouteTimetables> result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datetime1 = sdf.format(date) + " 00:00:00";
        String datetime2 = sdf.format(date) + " 23:59:59";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = formatter.parse(datetime1);
            date2 = formatter.parse(datetime2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result = routeTimetablesDao.getStationTimetableArr(station, date1, date2);

        return result;
    }

    public List<RouteTimetables> getTimetableStationDep(Station station, Date date) {
        List<RouteTimetables> result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datetime1 = sdf.format(date) + " 00:00:00";
        String datetime2 = sdf.format(date) + " 23:59:59";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = formatter.parse(datetime1);
            date2 = formatter.parse(datetime2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        result = routeTimetablesDao.getStationTimetableDep(station, date1, date2);
        return result;
    }

    @Override
    public Map<Integer,List<Integer>> getRoutes() {
        //отсортированный список RT по номеру в маршруте (numberInRoute)
        //сначала идут первые
        //сделано для того, чтобы добавлялись станции по порядку
        List<RouteTimetables> allroutes = routeTimetablesDao.getRoutes();
        //Пример: маршрут 1: 2134 (id станций)
        Map<Integer,List<Integer>> routes = new HashMap<>();
        for (RouteTimetables r: allroutes) {
            //если такой маршрут еще не существует, то добавляю станцию отправления и станцию прибытия
            int idroute = r.getRouteId().getIdRoute();
            //ПАДАЕТ
            if (!routes.containsKey(idroute))
             {
                 //создаю список с id станций отправки и прибытия (касается только у кого numberInRoute=1)
                 List<Integer> route = new ArrayList<>();
                 route.add(r.getLine().getStationDeparture().getIdStation());
                 route.add(r.getLine().getStationArrival().getIdStation());
                 routes.put(idroute,route) ;
            } else {
                //работаю с маршрутом
                List <Integer> myRoute = routes.get(idroute);
                //если нет в списке маршрута станции прибытия,то добавляю её
                if (!myRoute.contains(r.getLine().getStationArrival().getIdStation()))
                {
                    routes.get(idroute).add(r.getLine().getStationArrival().getIdStation());
                }
            }
        }
        return  routes;
    }
}


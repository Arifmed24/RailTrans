package services.impl;

import org.apache.commons.lang.time.DateUtils;
import persistence.DaoException;
import persistence.dao.api.RouteDao;
import persistence.dao.api.RouteTimetablesDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import persistence.entities.Timetable;
import services.api.RouteTimatablesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by abalaev on 06.10.2016.
 */
public class RouteTimetableServiceImpl implements RouteTimatablesService {

    RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
    RouteDao routeDao = FactoryDao.getRouteDao();

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

    @Override
    public List<List<RouteTimetables>> findWay(Station stationBegin, Station stationEnd, Date dateBegin, Date dateEnd) {
        List<List<RouteTimetables>> result = new ArrayList<>();
        Map<Integer,List<Integer>> routes = this.getRoutes();
        int stationBeginId = stationBegin.getIdStation();
        int statonEndId = stationEnd.getIdStation();

        for(Map.Entry<Integer,List<Integer>> entry : routes.entrySet()){
//            System.out.println(entry.getKey()+" : "+ entry.getValue());
            int start = -1, finish =-1;
            int sj =-1 ,fj =-1;
            for (int i=0; i<entry.getValue().size();i++)
            {
                if (stationBeginId==entry.getValue().get(i))
                {
                    start=entry.getValue().get(i);
                    sj = i;
                }
                if (statonEndId==entry.getValue().get(i)){
                    finish = entry.getValue().get(i);
                    fj = i;
                }
            }
            if (start!=-1 && finish!=-1 && sj<fj)
            {
               for (int i=sj+1;i<fj+1;i++) {
                   if (i == sj + 1) {
                       List<RouteTimetables> startlines = null;
                       try {
                           startlines = routeTimetablesDao.getRouteTimetableByRouteAndNumberInRoute(routeDao.read(entry.getKey()), i,dateBegin,dateEnd);
                       } catch (DaoException e) {
                           e.printStackTrace();
                       }
                       for (RouteTimetables rt : startlines) {
                           List<RouteTimetables> way = new ArrayList<>();
                           way.add(rt);
                           result.add(way);
                       }
                   } else {
                       List<RouteTimetables> nextlines = null;
                       try {
                           nextlines = routeTimetablesDao.getRouteTimetableByRouteAndNumberInRoute(routeDao.read(entry.getKey()), i,dateBegin,dateEnd);
                       } catch (DaoException e) {
                           e.printStackTrace();
                       }
                       for (RouteTimetables line: nextlines) {
                           for (List<RouteTimetables> list: result) {
                               if (line.getNumberInRoute()-list.get(list.size()-1).getNumberInRoute()==1){
                                   if (line.getDateDeparture().after(list.get(list.size()-1).getDateDeparture()))
                                   {
                                       list.add(line);
                                   }
                               }
                           }
                       }
                   }
               }
               int count = fj-sj;
                /**
                 * НЕВЕРНО
                 */
//                for (int i=0; i<result.size();i++) {
//                    List<RouteTimetables> r = result.get(i);
//                    if (r.size()!=count)
//                    {
//                        result.remove(r);
//                    }
//                }
                for (Iterator<List<RouteTimetables>> iterator = result.iterator();iterator.hasNext();){
                    List<RouteTimetables> variant = iterator.next();
                    if (variant.size()!=count)
                    {
//                        result.remove(variant);
                        iterator.remove();
                    }
                }
            }
        }
        return result;
    }
}


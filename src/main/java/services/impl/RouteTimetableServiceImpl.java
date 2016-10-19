package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.RouteDao;
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

    private static final Logger LOG = Logger.getLogger(RouteTimetableServiceImpl.class);


    private static final int MILLIS_IN_MIN = 60000;

    private RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
    private RouteDao routeDao = FactoryDao.getRouteDao();

    private Date[] formatDate(Date date){
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
            LOG.error("Error with date parsing ", e);
        }
        return new Date[]{date1,date2};
    }

    public List<RouteTimetables> getTimetableStationArr(Station station, Date date) {
        Date[] dates = formatDate(date);
        Date date1 = dates[0];
        Date date2 = dates[1];
        LOG.info("getting station timetable for arriving");
        return routeTimetablesDao.getStationTimetableArr(station, date1, date2);
    }

    public List<RouteTimetables> getTimetableStationDep(Station station, Date date) {
        Date[] dates = formatDate(date);
        Date date1 = dates[0];
        Date date2 = dates[1];
        LOG.info("getting station timetable for departure");
        return routeTimetablesDao.getStationTimetableDep(station, date1, date2);
    }

    @Override
    public Map<Integer, List<Integer>> getRoutes() {
        List<RouteTimetables> allRoutes = routeTimetablesDao.getRoutes();
        Map<Integer,List<Integer>> routes = new HashMap<>();
        for (RouteTimetables r: allRoutes) {
            int idRoute = r.getRouteId().getIdRoute();
            if (!routes.containsKey(idRoute))
             {
                 List<Integer> route = new ArrayList<>();
                 route.add(r.getLine().getStationDeparture().getIdStation());
                 route.add(r.getLine().getStationArrival().getIdStation());
                 routes.put(idRoute,route) ;
            } else {
                List <Integer> myRoute = routes.get(idRoute);
                if (!myRoute.contains(r.getLine().getStationArrival().getIdStation()))
                {
                    routes.get(idRoute).add(r.getLine().getStationArrival().getIdStation());
                }
            }
        }
        LOG.info("get map of routes");
        return  routes;
    }


    @Override
    public List<List<RouteTimetables>> findWay(Station stationBegin, Station stationEnd, Date dateBegin, Date dateEnd) {
        List<List<RouteTimetables>> result = new ArrayList<>();
        Map<Integer,List<Integer>> routes = this.getRoutes();
        int stationBeginId = stationBegin.getIdStation();
        int stationEndId = stationEnd.getIdStation();

        LOG.info("finding variants of ways");
        //берем Map всех маршрутов
        for(Map.Entry<Integer,List<Integer>> entry : routes.entrySet()){
            int start = -1, finish =-1;
            int sj =-1 ,fj =-1;
            //проходимся по маршруту
            for (int i=0; i<entry.getValue().size();i++)
            {
                //если станция равна начальной, то записываем ее индекс
                if (stationBeginId==entry.getValue().get(i))
                {
                    start=entry.getValue().get(i);
                    sj = i;
                }
                //если станция равна конечной, то записываем ее индекс
                if (stationEndId==entry.getValue().get(i)){
                    finish = entry.getValue().get(i);
                    fj = i;
                }
            }
            //если начальная и конечная станции есть в маршруте и конечная стоит после начальной
            if (start!=-1 && finish!=-1 && sj<fj)
            {

                //идем по маршруту с начальной до конечной (берем отрезки)
               for (int i=sj+1;i<fj+1;i++) {
                   //если отрезок первый по счету
                   if (i == sj + 1) {
                       //создаем список
                       List<RouteTimetables> startLines = null;
                           //берем все встречающиеся перые номера отрезков в маршруте за этот период времени
                           //в них должны быть свободные места (кол-во свободных мест > 0)
                           startLines = routeTimetablesDao.getRouteTimetableByRouteAndNumberInRoute(routeDao.read(entry.getKey()), i,dateBegin,dateEnd);
                       //каждый первый отрезок помещаем в новый список (будущий вариант)
                       for (RouteTimetables rt : startLines) {
                           List<RouteTimetables> way = new ArrayList<>();
                           way.add(rt);
                           LOG.info("variant created");
                           result.add(way);
                       }
                   } else {
                       //если отрезок не первый
                       List<RouteTimetables> nextLines = null;
                           //берем все встречающиеся номера отрезков в маршруте за этот период времени
                           //в них должны быть свободные места (кол-во свободных мест > 0)
                           nextLines = routeTimetablesDao.getRouteTimetableByRouteAndNumberInRoute(routeDao.read(entry.getKey()), i,dateBegin,dateEnd);
                       //проходимся по найденным отрезкам n-ого номера в маршруе
                       for (RouteTimetables line: nextLines) {
                           //берем имеющийся список отрезков из списка списков отрезков
                           for (List<RouteTimetables> list: result) {
                               //если в конечном списке еще нет n-ого отрезка маршрута
                               if (line.getNumberInRoute()-list.get(list.size()-1).getNumberInRoute()==1){
                                   //если дата отправки n-ого отрезка стоит после даты отправки последнего элемента в списке
                                   if (line.getDateDeparture().after(list.get(list.size()-1).getDateDeparture()))
                                   {
                                       //добавляем в список
                                       list.add(line);
                                   }
                               }
                           }
                       }
                   }
               }
                //сколько должно быть элементов в варианте
               int count = fj-sj;
                //настоящее время
                Date now = new Date();
                //проходимся по полученным вариантам
                for (Iterator<List<RouteTimetables>> iterator = result.iterator();iterator.hasNext();){
                    List<RouteTimetables> variant = iterator.next();
                    //если они не полные, то удаляем
                    if (variant.size()!=count)
                    {
                        LOG.info("variant was incorrect and deleted");
                        iterator.remove();
                    }
                    else {
                        LOG.info("variant is correct");
                    }
                    //если первый отрезок маршрута начинается раньше, чем 10 минут от настоящего времени
                    if ((int)((variant.get(0).getDateDeparture().getTime()/ MILLIS_IN_MIN) - now.getTime()/ MILLIS_IN_MIN)<10){
                        LOG.info("variant started earlier than 10 minutes before first row started");
                        iterator.remove();
                    } else {
                        LOG.info("start time of variant is correct");
                    }
                }
            }
        }
        LOG.info("finished finding");
        return result;
    }


    @Override
    public RouteTimetables updateRouteTimetable(RouteTimetables routeTimetables) {
        RouteTimetables result = null;
            result = routeTimetablesDao.update(routeTimetables);
            LOG.info("timetable {} updated", result);
        return result;
    }
}



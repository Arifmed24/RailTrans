package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.RouteDao;
import persistence.dao.api.RouteTimetablesDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Route;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import services.api.RouteTimatablesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RouteTimetableServiceImpl implements RouteTimatablesService {

    private static final Logger LOG = Logger.getLogger(RouteTimetableServiceImpl.class);
    //millisecond in minute
    private static final int MILLIS_IN_MIN = 60000;

    private RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
    private RouteDao routeDao = FactoryDao.getRouteDao();

    /**
     * insert routeTimetable in database
     * @param routeTimetables       routeTimetable entity
     * @return                      routeTimetable
     */
    public RouteTimetables createRoutetimetable(RouteTimetables routeTimetables) {
        RouteTimetables result;
        result = routeTimetablesDao.update(routeTimetables);
        return result;
    }

    /**
     * format day in two dates with time 00:00:00 and 23:59:59
     * @param date      date
     * @return          formatted date
     */
    private Date[] formatDate(Date date) {
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
        return new Date[]{date1, date2};
    }

    /**
     * get station arrival timetable to determined date
     * @param station       station
     * @param date          date
     * @return              list of routeTimetables
     */
    public List<RouteTimetables> getTimetableStationArr(Station station, Date date) {
        Date[] dates = formatDate(date);
        Date date1 = dates[0];
        Date date2 = dates[1];
        LOG.info("getting station timetable for arriving");
        return routeTimetablesDao.getStationTimetableArr(station, date1, date2);
    }

    /**
     * get station departure timetable to determined date
     * @param station       station
     * @param date          date
     * @return              list of routeTimetables
     */
    public List<RouteTimetables> getTimetableStationDep(Station station, Date date) {
        Date[] dates = formatDate(date);
        Date date1 = dates[0];
        Date date2 = dates[1];
        LOG.info("getting station timetable for departure");
        return routeTimetablesDao.getStationTimetableDep(station, date1, date2);
    }

    /**
     * get map of all routes
     * @return      all routes (keys - names, values - lists of routeTimetables)
     */
    public Map<Integer, List<Integer>> getRoutes() {
        LOG.info("start getting all routes");
        List<RouteTimetables> allRoutes = routeTimetablesDao.getRoutes();
        Map<Integer, List<Integer>> routes = new HashMap<>();
        for (RouteTimetables r : allRoutes) {
            int idRoute = r.getRouteId().getIdRoute();
            if (!routes.containsKey(idRoute)) {
                List<Integer> route = new ArrayList<>();
                route.add(r.getLine().getStationDeparture().getIdStation());
                route.add(r.getLine().getStationArrival().getIdStation());
                routes.put(idRoute, route);
            } else {
                List<Integer> myRoute = routes.get(idRoute);
                if (!myRoute.contains(r.getLine().getStationArrival().getIdStation())) {
                    routes.get(idRoute).add(r.getLine().getStationArrival().getIdStation());
                }
            }
        }
        LOG.info("finish getting all routes");
        return routes;
    }


    /**
     * find list of variants of way between two stations in time interval
     * @param stationBegin      start station
     * @param stationEnd        finish station
     * @param dateBegin         begin interval
     * @param dateEnd           end interval
     * @return                  list of variants
     */
    public List<List<RouteTimetables>> findWay(Station stationBegin, Station stationEnd, Date dateBegin, Date dateEnd) {
        List<List<RouteTimetables>> result = new ArrayList<>();
        Map<Integer, List<Integer>> routes = this.getRoutes();
        int stationBeginId = stationBegin.getIdStation();
        int stationEndId = stationEnd.getIdStation();
        //first segments in variants
        List<RouteTimetables> startLines = null;
        int size = result.size();
        LOG.info("finding variants of ways");
        //take a map of all routes
        for (Map.Entry<Integer, List<Integer>> entry : routes.entrySet()) {
            //flags
            int start = -1, finish = -1;
            //indexes of stations in route
            int sj = -1, fj = -1;
            //go through each of route
            for (int i = 0; i < entry.getValue().size(); i++) {
                //if station in route equals stationBegin, record index of station to sj
                if (stationBeginId == entry.getValue().get(i)) {
                    start = entry.getValue().get(i);
                    sj = i;
                }
                //if station in route equals stationEnd, record index of station to fj
                if (stationEndId == entry.getValue().get(i)) {
                    finish = entry.getValue().get(i);
                    fj = i;
                }
            }
            //if route have this stations and start station stays earlier than finish station
            if (start != -1 && finish != -1 && sj < fj) {
                //take all segments (timetables) in route between start and finish stations
                for (int i = sj + 1; i < fj + 1; i++) {
                    //if this first segment
                    if (i == sj + 1) {
                        //take all first segments in all graphics of this route
                        //segments must have free seats
                        startLines = routeTimetablesDao.getRouteTimetableByRouteAndNumberInRoute(routeDao.read(entry.getKey()), i, dateBegin, dateEnd);
                        //each of segments put in new array list (future result)
                        for (RouteTimetables rt : startLines) {
                            List<RouteTimetables> way = new ArrayList<>();
                            way.add(rt);
                            LOG.info("variant created");
                            result.add(way);
                        }
                        //if this not first segment
                    } else {
                        if (startLines.size() != 0) {
                            List<RouteTimetables> nextLines;
                            //take all segments with this index in all graphics of this route
                            //segments must have free seats
                            nextLines = routeTimetablesDao.getRouteTimetableByRouteAndNumberInRoute(routeDao.read(entry.getKey()), i, dateBegin, dateEnd);
                            //go through all segments (this segment is determined number in route - routeTimetable
                            for (RouteTimetables line : nextLines) {
                                //go through variants
                                for (List<RouteTimetables> list : result) {
                                    //if variant doesn't have this segment
                                    if (line.getNumberInRoute() - list.get(list.size() - 1).getNumberInRoute() == 1) {
                                        //if date arrival of this segment before date arrival of last segment in variant
                                        if (line.getDateDeparture().after(list.get(list.size() - 1).getDateDeparture())) {
                                            //add in variant
                                            list.add(line);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //if result size has changed
                if (result.size()!=size){
                    //check variants
                    int count = fj - sj;
                    //present time
                    Date now = new Date();
                    //go through variants
                    for (Iterator<List<RouteTimetables>> iterator = result.iterator(); iterator.hasNext(); ) {
                        List<RouteTimetables> variant = iterator.next();
                        //if variant not completed
                        if (variant.size() != count) {
                            LOG.info("variant was incorrect and deleted");
                            //remove this variant
                            iterator.remove();
                        } else {
                            LOG.info("variant is correct");
                        }
                        //if first segment in variant is earlier than 10 minutes than real time
                        if ((int) ((variant.get(0).getDateDeparture().getTime() / MILLIS_IN_MIN) - now.getTime() / MILLIS_IN_MIN) < 10) {
                            LOG.info("variant started earlier than 10 minutes before first row started");
                            //remove this variant
                            iterator.remove();
                        } else {
                            LOG.info("start time of variant is correct");
                        }
                    }
                }
                size = result.size();
            }
        }
        LOG.info("finished finding");
        return result;
    }


    /**
     * update routeTimetable
     * @param routeTimetables       routeTimetable entity
     * @return                      routeTimetable
     */
    public RouteTimetables updateRouteTimetable(RouteTimetables routeTimetables) {
        RouteTimetables result;
        result = routeTimetablesDao.update(routeTimetables);
        LOG.info("timetable {} updated", result);
        return result;
    }


    /**
     * create template from new graphic of route
     * @param route     route
     * @return          list of routeTimetables
     */
    public List<RouteTimetables> createTemplateOfGraphic(Route route) {
        LOG.info("start creating template for new graphic");
        List<RouteTimetables> template = routeTimetablesDao.getListRtByRoute(route);
        List<RouteTimetables> graphicTemplate = new ArrayList<>();
        for (RouteTimetables r : template) {
            RouteTimetables routeTimetables = new RouteTimetables();
            routeTimetables.setLine(r.getLine());
            routeTimetables.setDateDeparture(new Date());
            routeTimetables.setDateArrival(new Date());
            routeTimetables.setFreeSeats(route.getTrain().getSeats());
            routeTimetables.setRouteId(route);
            routeTimetables.setNumberInRoute(r.getNumberInRoute());
            graphicTemplate.add(routeTimetables);
        }
        LOG.info("finish creating template for new graphic");
        return graphicTemplate;
    }

    /**
     * add date interval in template of route
     * @param dates     dates
     * @param route     route
     * @return          finished route graphic
     * @throws Exception       dates are incorrect
     */
    public List<RouteTimetables> addDateInGraphic(List<Date> dates, Route route) throws Exception {
        LOG.info("start adding dates in graphic template");
        List<RouteTimetables> finalList = createTemplateOfGraphic(route);
        for (int i=1; i<dates.size(); i++){
            if (dates.get(i).before(dates.get(i-1))){
                LOG.error("dates are not correct");
                throw new Exception("Date arrival must be after date departure and earlier than next date departure");
            }
        }
        for (int i=0; i<finalList.size();i++){
            finalList.get(i).setDateDeparture(dates.get(i*2));
            finalList.get(i).setDateArrival(dates.get(i*2+1));
        }
        LOG.info("finish adding dates in graphic template");
        return finalList;
    }

    /**
     * create new graphic
     * @param routeTimetables   routeTimetables
     * @return         graphic
     */
    public List<RouteTimetables> createGraphic(List<RouteTimetables> routeTimetables) {
        LOG.info("start creating new graphic");
        List<RouteTimetables> result = new ArrayList<>();
        for (RouteTimetables r : routeTimetables) {
            RouteTimetables newRouteTimetable = new RouteTimetables();
            newRouteTimetable.setDateDeparture(r.getDateDeparture());
            newRouteTimetable.setDateArrival(r.getDateArrival());
            newRouteTimetable.setFreeSeats(r.getFreeSeats());
            newRouteTimetable.setLine(r.getLine());
            newRouteTimetable.setRouteId(r.getRouteId());
            newRouteTimetable.setNumberInRoute(r.getNumberInRoute());
            newRouteTimetable = createRoutetimetable(newRouteTimetable);
            result.add(newRouteTimetable);
        }
        LOG.info("finish creating new graphic");
        return result;
    }

    /**
     * check order of dates
     * @param dates    string dates
     * @return      dates
     * @throws Exception    wrong order
     */
    public List<Date> checkDatesInRoute(List<String> dates) throws Exception {
        LOG.info("start checking dates of route");
        List<Date> routeDates = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        for (String sDate : dates) {
            Date date;
            try {
                date = sdf.parse(sDate);
                routeDates.add(date);
            } catch (ParseException e) {
                LOG.error("wrong format of date");
                throw new Exception("Some date was incorrect, please use calendar");
            }
        }
        for (int i=1; i<routeDates.size(); i++){
            if (routeDates.get(i).before(routeDates.get(i-1))){
                LOG.error("dates are not correct");
                throw new Exception("Date arrival must be after date departure and earlier than next date departure");
            }
        }
        LOG.info("finish checking dates of route");
        return routeDates;
    }
}




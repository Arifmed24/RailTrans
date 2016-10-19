package presentation;

import org.apache.log4j.Logger;
import persistence.dao.api.*;
import persistence.dao.impl.*;
import persistence.entities.*;
import services.api.PassengerService;
import services.api.RouteTimatablesService;
import services.api.TicketService;
import services.impl.FactoryService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.SQLException;

/**
 * Created by abalaev on 30.09.2016.
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        LOG.info("test testtesttesttesttesttesttesttest");

//        PassengerDaoImpl passengerDao = new PassengerDaoImpl();
//        Passenger passenger = new Passenger();
//        passenger.setFirstName("FirstName");
//        passenger.setLastName("LastName");
//        passenger.setBirth(new Date());
//
//        Passenger passenger1 = new Passenger();
//        passenger1.setFirstName("FirstName1");
//        passenger1.setLastName("LastName1");
//        passenger1.setBirth(new Date());
//
//        Passenger passenger11 = passengerDao.create(passenger);
//        Passenger passenger2 = passengerDao.create(passenger1);
//
//        System.out.println(passenger11.getIdPassenger());
//        System.out.println(passenger2.getIdPassenger());
//
//        Passenger read = passengerDao.read(passenger11.getIdPassenger());

//        User user1 = new User();
//        user1.setLogin("admin");
//        user1.setPassword("qwerty123");
//        user1.setRole(RoleEnum.ADMIN);
//        UserDaoImpl userDao = new UserDaoImpl();
//        User user11 = userDao.create(user1);
//        System.out.println(userDao.findByLogin("admin"));
      /*  TimetableDao timetableDao = new TimetableDaoImpl();
        Station station = new Station();
        station.setStationName("Мга");
        station.setIdStation(2);
        List<Timetable> timetables;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = "15/10/2016";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TrainDao trainDao = new TrainDaoImpl();
        //ПРИБЫТИЕ
        timetables = timetableDao.getStationTimetableDep(station,date);
        System.out.println("Нахождение расписания поездов по станции. Пример: станция Мга, номер 2");
        for (Timetable t: timetables) {
            System.out.println(" Маршрут: "+t.getRouteId().getRouteName()+
                    " Выезд: " +t.getDateDeparture()+
                    " Поезд: "+trainDao.findTrainByTimetable(t.getIdLine()).getIdTrain()+
                    " Конечная: "+ t.getFouteId().getFinishStation().getStationName());

        }*/

    /*    System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();*/

        /*
        //ОТБЫТИЕ
        timetables = timetableDao.getStationTimetableArr(station,date);
        for (Timetable t: timetables) {
            System.out.println(t.toString());
        }

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        */


    /*    StationDao stationDao = new StationDaoImpl();
        Station station1 = stationDao.findStationByName("Пупышево");
        System.out.println(station1);


        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        System.out.println("Вывод всех станций: ");
        List<Station> stations = stationDao.getAll();
        for (Station s : stations) {
            System.out.println(s.getStationName());
        }

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        System.out.println("Вывод станций маршрута: ");
        RouteDao routeDao = new RouteDaoImpl();
        Route route = null;
        try {
          route  = routeDao.read(2);
        }catch (DaoException e)
        {

        }
        Set<Timetable> timetableSet = route.getTimetables();
        for (Timetable t3: timetableSet) {
            System.out.println(t3);
        }*/


//        route.setFinishDate();
//        System.out.println(route.getFinishDate());

//        StationDao stationDao = new StationDaoImpl();
//        Station station = null;
//        try {
//            station = stationDao.read(1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        List<Timetable> timetablesD = station.getTimetablesDep();
//        List<Timetable> timetablesA = station.getTimetablesArr();
//        System.out.println("Timetable of station №1");
//        System.out.println("Departure");
//        for (Timetable t: timetablesD) {
//            System.out.println("В: "+ t.getStationArrival().getStationName());
//            List<RouteTimetables> rt = t.getRouteTimetables();
//            for (RouteTimetables r: rt) {
//                System.out.println("Отправление: "+ r.getDateDeparture() + " / Прибытие: " + r.getDateArrival());
//            }
//        }
//        System.out.println();
//        System.out.println("Arrival");
//        for (Timetable t: timetablesA) {
//            System.out.println("Из: "+ t.getStationDeparture().getStationName());
//
//        }

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

//        TimetableDao timetableDao = new TimetableDaoImpl();
//        Timetable timetable  = null;
//        try {
//            timetable = timetableDao.read(1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        List<RouteTimetables> routeTimetables = timetable.getRouteTimetables();
//        for (RouteTimetables r: routeTimetables) {
//            System.out.println("Выезд: " + r.getDateDeparture()+ " Приезд: "+ r.getDateArrival()+ " Маршрут: " +r.getRouteId().getRouteName());
//        }
//
//        System.out.println();
//        System.out.println("---------------------------------------------");
//        System.out.println();

//        RouteDao routeDao = new RouteDaoImpl();
//        Route route = null;
//        try {
//            route = routeDao.read(1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        List<RouteTimetables> routeTimetables1 = route.getRouteTimetablesList();
//        for (RouteTimetables r: routeTimetables1) {
//            System.out.println("Выезд: " + r.getDateDeparture()+ " Приезд: "+ r.getDateArrival()+ " Маршрут: " +r.getRouteId().getRouteName());
//        }

//        System.out.println();
//        System.out.println("---------------------------------------------");
//        System.out.println();
//
//        TrainDao trainDao = new TrainDaoImpl();
//        Train train = null;
//        try {
//            train = trainDao.read(1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        List<Route> routes = train.getRoutes();
//        for (Route ro: routes) {
//            System.out.println(ro.getRouteName());
//        }

//        System.out.println();
//        System.out.println("---------------------------------------------");
//        System.out.println();
//
//        RouteTimetablesDao routeTimetablesDao = new RouteTimetablesDaoImpl();
//        List<RouteTimetables> routeTimetables2 = routeTimetablesDao.getAll();
//        for (RouteTimetables rot: routeTimetables2) {
//           System.out.println("Из: "+ rot.getLine().getStationDeparture().getStationName()+ " Время: "+ rot.getDateDeparture()+ "/////В: "+ rot.getLine().getStationArrival().getStationName()+ " Время: "+ rot.getDateArrival());
//            System.out.println(rot);
//        }
//
      /*  RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
        Station station = new Station();
        station.setIdStation(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = null;
        Date d2 = null;
        try {
            d = sdf.parse("2016-10-15 00:00:00");
            d2 = sdf.parse("2016-10-15 23:50:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<RouteTimetables> routeTimetables = routeTimetablesDao.getStationTimetableArr(station,d,d2);
        for (RouteTimetables r: routeTimetables) {
            System.out.println(r);
        }
    }*/


        /**
         * тестим функцию getRoute
         */
//        RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
//        List<RouteTimetables> routeTimetables = routeTimetablesDao.getRoutes();
//        for (RouteTimetables rt : routeTimetables) {
//            System.out.println(rt);
//        }


//        RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();
//        Map<Integer,List<Integer>> routes = routeTimatablesService.getRoutes();
//        for(Map.Entry<Integer,List<Integer>> entry : routes.entrySet()){
//            System.out.println(entry.getKey()+" : "+ entry.getValue());
//        }

//        RouteTimatablesService routeTimatablesService = FactoryService.getRouteTimatablesService();
//        Route route = new Route();
//        route.setIdRoute(2);
//        Station station1 = new Station();
//        Station station2 = new Station();
//        station1.setIdStation(3);
//        station2.setIdStation(1);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = null;
//        Date d2 = null;
//        try {
//            d = sdf.parse("2016-10-15");
//            d2 = sdf.parse("2016-11-24");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        List<List<RouteTimetables>> routeTimetables = routeTimatablesService.findWay(station1,station2,d,d2);
//        int i = 1;
//        for (List<RouteTimetables> r: routeTimetables) {
//            System.out.println("Вариант: "+ i);
//            for (RouteTimetables routes: r) {
//                System.out.println(routes);
//            }
//            i++;
//        }

//        TicketService ticketService = FactoryService.getTicketService();
//        List<Ticket> tickets = ticketService.getTicketsFromRtLists(routeTimetables);
//
//        for (Ticket ticket: tickets) {
//            System.out.println(ticket);
//        }


//        String b = "24/11/1995";
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date birth = null;
//        try {
//            birth = sdf.parse(b);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        PassengerDao passengerDao = FactoryDao.getPassengerDao();
//        List<Passenger> passengers = passengerDao.findPassenger("Arif","wBalaev",birth);
//        System.out.println(passengers);

//        PassengerService passengerService = FactoryService.getPassengerService();
//        RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
//        List<RouteTimetables> routeTimetables = new ArrayList<>();
//        RouteTimetables routeTimetables1 = null;
//        RouteTimetables routeTimetables2 = null;
//        RouteTimetables routeTimetables3 = null;
//        try {
//            routeTimetables1= routeTimetablesDao.read(2);
//            routeTimetables2 = routeTimetablesDao.read(3);
//            routeTimetables3 = routeTimetablesDao.read(6);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        routeTimetables.add(routeTimetables1);
//        routeTimetables.add(routeTimetables2);
//        routeTimetables.add(routeTimetables3);
//        Set<Passenger> passengers = passengerService.getPassengersOfRoute(routeTimetables);
//        for (Passenger p: passengers) {
//            System.out.println(p);
//        }

//        Date date = new Date();
//        RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
//        RouteTimetables routeTimetables = null;
//        try {
//            routeTimetables = routeTimetablesDao.read(1);
//        } catch (DaoException e) {
//            e.printStackTrace();
//        }
//        Date date1 = routeTimetables.getDateDeparture();
//        System.out.println(date.getTime());
//        System.out.println(date1.getTime());
//        System.out.println(date1.getTime()-date);

//        UserDao userDao = FactoryDao.getUserDao();
//        User user = new User();
//        user.setLogin("gector");
//        user.setPassword("qwe");
//        user.setFio("Genadyi Tortov");
//        user.setRole(RoleEnum.USER);
//        try {
//            userDao.create(user);
//        } catch (DaoException e) {
//
//
//        }

        System.out.println("Hello");

    }
}

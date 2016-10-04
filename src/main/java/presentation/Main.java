package presentation;

import persistence.DaoException;
import persistence.dao.api.RouteDao;
import persistence.dao.api.StationDao;
import persistence.dao.api.TimetableDao;
import persistence.dao.impl.*;
import persistence.entities.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException {

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
        TimetableDao timetableDao = new TimetableDaoImpl();
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
        timetables = timetableDao.getStationTimetable(station,date);
        for (Timetable t: timetables) {
            System.out.println(t.toString());
        }

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        StationDao stationDao = new StationDaoImpl();
        Station station1 = stationDao.findStationByName("Пупышево");
        System.out.println(station1);


        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();


        RouteDao routeDao = new RouteDaoImpl();
//        List<Timetable> timetables2 = routeDao.findTimetablesOfRoute(1);
//        for (Timetable timetable2: timetables2) {
//            System.out.println(timetable2);
//        }
        Route route = null;
        try {
            route = routeDao.read(1);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        for (Timetable t2: route.getTimetables())
        {
            System.out.println(t2);
        }
    }
}

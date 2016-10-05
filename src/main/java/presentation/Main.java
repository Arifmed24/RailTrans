package presentation;

import persistence.DaoException;
import persistence.dao.api.RouteDao;
import persistence.dao.api.StationDao;
import persistence.dao.api.TimetableDao;
import persistence.dao.api.TrainDao;
import persistence.dao.impl.*;
import persistence.entities.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

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

        TrainDao trainDao = new TrainDaoImpl();
        //ПРИБЫТИЕ
        timetables = timetableDao.getStationTimetableDep(station,date);
        System.out.println("Нахождение расписания поездов по станции. Пример: станция Мга, номер 2");
        for (Timetable t: timetables) {
            System.out.println(" Маршрут: "+t.getRouteId().getRouteName()+
                    " Выезд: " +t.getDateDeparture()+
                    " Поезд: "+trainDao.findTrainByTimetable(t.getIdLine()).getIdTrain()+
                    " Конечная: "+ t.getRouteId().getFinishStation().getStationName());

        }

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

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


        StationDao stationDao = new StationDaoImpl();
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
        }



        route.setFinishDate();
        System.out.println(route.getFinishDate());
    }
}

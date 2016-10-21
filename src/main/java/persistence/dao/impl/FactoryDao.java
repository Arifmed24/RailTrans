package persistence.dao.impl;

import persistence.dao.api.*;

/**
 * Created by abalaev on 07.10.2016.
 */
public class FactoryDao {

    private static UserDao userDao;
    private static PassengerDao passengerDao;
    private static RouteDao routeDao;
    private static RouteTimetablesDao routeTimetablesDao;
    private static StationDao stationDao;
    private static TicketDao ticketDao;
    private static TrainDao trainDao;
    private static TimetableDao timetableDao;

    public static synchronized TimetableDao getTimetableDao() {
        if ( timetableDao == null) {
            timetableDao = new TimetableDaoImpl();
        }
        return timetableDao;
    }

    public static synchronized UserDao getUserDao() {
        if ( userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public static synchronized PassengerDao getPassengerDao() {
        if (passengerDao == null){
            passengerDao = new PassengerDaoImpl();
        }
        return passengerDao;
    }

    public static synchronized RouteDao getRouteDao() {
        if (routeDao == null){
            routeDao = new RouteDaoImpl();
        }
        return routeDao;
    }

    public static synchronized RouteTimetablesDao getRouteTimetablesDao() {
        if (routeTimetablesDao == null) {
            routeTimetablesDao = new RouteTimetablesDaoImpl();
        }
        return routeTimetablesDao;
    }

    public static synchronized StationDao getStationDao() {
        if (stationDao == null)
        {
            stationDao = new StationDaoImpl();
        }
        return stationDao;
    }

    public static synchronized TicketDao getTicketDao() {
        if (ticketDao == null){
            ticketDao = new TicketDaoImpl();
        }
        return ticketDao;
    }

    public static synchronized TrainDao getTrainDao() {
        if (trainDao == null){
            trainDao = new TrainDaoImpl();
        }
        return trainDao;
    }
}

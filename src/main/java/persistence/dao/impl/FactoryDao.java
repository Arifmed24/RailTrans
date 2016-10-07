package persistence.dao.impl;

import persistence.dao.api.*;
import persistence.entities.Ticket;
import persistence.entities.Train;

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

    public static TimetableDao getTimetableDao() {
        if ( timetableDao == null) {
            timetableDao = new TimetableDaoImpl();
        }
        return timetableDao;
    }

    public static UserDao getUserDao() {
        if ( userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    public static PassengerDao getPassengerDao() {
        if (passengerDao == null){
            passengerDao = new PassengerDaoImpl();
        }
        return passengerDao;
    }

    public static RouteDao getRouteDao() {
        if (routeDao == null){
            routeDao = new RouteDaoImpl();
        }
        return routeDao;
    }

    public static RouteTimetablesDao getRouteTimetablesDao() {
        if (routeTimetablesDao == null) {
            routeTimetablesDao = new RouteTimetablesDaoImpl();
        }
        return routeTimetablesDao;
    }

    public static StationDao getStationDao() {
        if (stationDao == null)
        {
            stationDao = new StationDaoImpl();
        }
        return stationDao;
    }

    public static TicketDao getTicketDao() {
        if (ticketDao == null){
            ticketDao = new TicketDaoImpl();
        }
        return ticketDao;
    }

    public static TrainDao getTrainDao() {
        if (trainDao == null){
            trainDao = new TrainDaoImpl();
        }
        return trainDao;
    }
}

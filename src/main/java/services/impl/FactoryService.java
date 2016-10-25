package services.impl;

import services.api.*;

public class FactoryService {

    private static UserService userService;
    private static PassengerService passengerService;
    private static RouteService routeService;
    private static RouteTimatablesService routeTimatablesService;
    private static StationService stationService;
    private static TicketService ticketService;
    private static TimetableService timetableService;
    private static TrainService trainService;

    public static UserService getUserService(){
        if (userService == null){
            userService = new UserServiceImpl();
        }
        return userService;
    }

    public static PassengerService getPassengerService() {
        if (passengerService == null){
            passengerService = new PassengerServiceImpl();
        }
        return passengerService;
    }

    public static RouteService getRouteService() {
        if (routeService == null){
            routeService = new RouteServiceImpl();
        }
        return routeService;
    }

    public static RouteTimatablesService getRouteTimatablesService() {
        if (routeTimatablesService == null){
            routeTimatablesService = new RouteTimetableServiceImpl();
        }
        return routeTimatablesService;
    }

    public static StationService getStationService() {
        if (stationService == null){
            stationService = new StationServiceImpl();
        }
        return stationService;
    }

    public static TicketService getTicketService() {
        if (ticketService == null){
            ticketService = new TicketServiceImpl();
        }
        return ticketService;
    }

    public static TimetableService getTimetableService() {
        if (timetableService == null){
            timetableService = new TimetableServiceImpl();
        }
        return timetableService;
    }

    public static TrainService getTrainService() {
        if (trainService == null){
            trainService = new TrainServiceImpl();
        }
        return trainService;
    }
}

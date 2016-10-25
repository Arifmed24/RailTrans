package services.api;


import persistence.entities.Route;

import java.util.List;

public interface RouteService {
    Route createRoute(Route route);
    List<Route> getAllRoutes();
    Route readRoute(int id);
}

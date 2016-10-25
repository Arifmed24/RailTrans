package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.RouteDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Route;
import services.api.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private static final Logger LOG = Logger.getLogger(RouteServiceImpl.class);
    private RouteDao routeDao = FactoryDao.getRouteDao();

    /**
     * create route
     * @param route     route entity
     * @return          route
     */
    public Route createRoute(Route route) {
        Route result;
            result = routeDao.create(route);
            LOG.info("route created {}", result);
        return result;
    }

    /**
     * get all routes
     * @return     list of routes
     */
    public List<Route> getAllRoutes() {
        LOG.info("get all routes");
       return routeDao.getAll();
    }

    /**
     * get route by id
     * @param id        id
     * @return          route
     */
    public Route readRoute(int id) {
        LOG.info("read route");
        return routeDao.read(id);
    }
}

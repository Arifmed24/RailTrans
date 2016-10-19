package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.RouteDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Route;
import services.api.RouteService;

/**
 * Created by abalaev on 07.10.2016.
 */
public class RouteServiceImpl implements RouteService {

    private static final Logger LOG = Logger.getLogger(RouteServiceImpl.class);
    private RouteDao routeDao = FactoryDao.getRouteDao();

    @Override
    public Route createRoute(Route route) {
        Route result = null;
            result = routeDao.create(route);
            LOG.info("route created {}", result);
        return result;
    }


}

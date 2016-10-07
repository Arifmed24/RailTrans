package services.impl;

import persistence.dao.api.RouteDao;
import persistence.dao.impl.FactoryDao;
import services.api.RouteService;

/**
 * Created by abalaev on 07.10.2016.
 */
public class RouteServiceImpl implements RouteService {
    RouteDao routeDao = FactoryDao.getRouteDao();
}

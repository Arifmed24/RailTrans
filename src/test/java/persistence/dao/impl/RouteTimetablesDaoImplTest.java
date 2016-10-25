package persistence.dao.impl;

import org.junit.Test;
import persistence.dao.api.RouteDao;
import persistence.dao.api.RouteTimetablesDao;
import persistence.entities.Route;
import persistence.entities.RouteTimetables;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by abalaev on 22.10.2016.
 */
public class RouteTimetablesDaoImplTest {
    @Test
    public void getListRtByRoute() throws Exception {
        RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();
        RouteDao routeDao = FactoryDao.getRouteDao();
        Route route = routeDao.read(1);
        List<RouteTimetables> result = routeTimetablesDao.getListRtByRoute(route);
        assertTrue(result.size()==3);
    }

}
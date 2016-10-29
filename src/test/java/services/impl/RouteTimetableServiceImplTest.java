package services.impl;

import org.junit.Before;
import org.junit.Test;
import persistence.dao.api.RouteTimetablesDao;
import persistence.entities.Route;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import services.api.RouteTimatablesService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by abalaev on 26.10.2016.
 */
public class RouteTimetableServiceImplTest {


    @Test
    public void findWay() throws Exception {
        RouteTimetableServiceImpl routeTimatablesService = new RouteTimetableServiceImpl();
        RouteTimetableServiceImpl routeTimetableService2 = mock(RouteTimetableServiceImpl.class);

        List<Integer> route1 = Arrays.asList(2,1,3,4);
        List<Integer> route2 = Arrays.asList(4,3,5,1,2);
        List<Integer> route3 = Arrays.asList(2,3,4,5);
        Map<Integer,List<Integer>> map = new HashMap<>();
        map.put(1,route1);
        map.put(2,route2);
        map.put(3,route3);

        Station stationBegin = mock(Station.class);
        Station stationEnd = mock(Station.class);


        when(stationBegin.getIdStation()).thenReturn(3);
        when(stationEnd.getIdStation()).thenReturn(4);
        when(routeTimetableService2.getRoutes()).thenReturn(map);
        routeTimatablesService = routeTimetableService2;

//        when()
    }

    @Test
    public void createRoutetimetable() throws Exception {

        RouteTimetableServiceImpl routeTimatablesService = new RouteTimetableServiceImpl();

        RouteTimetablesDao routeTimetablesDao = mock(RouteTimetablesDao.class);
        routeTimatablesService.setRouteTimetablesDao(routeTimetablesDao);

        RouteTimetables routeTimetables = mock(RouteTimetables.class);
        Route route = mock(Route.class);

        when(routeTimetablesDao.update(routeTimetables)).thenReturn(routeTimetables);

        assertEquals(routeTimetables,routeTimatablesService.createRoutetimetable(routeTimetables));
    }

}
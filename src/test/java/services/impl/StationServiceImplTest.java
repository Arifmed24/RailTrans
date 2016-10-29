package services.impl;

import org.junit.Test;
import persistence.dao.api.StationDao;
import persistence.entities.Route;
import persistence.entities.Station;
import persistence.entities.Train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by abalaev on 26.10.2016.
 */
public class StationServiceImplTest {
    @Test
    public void checkStationsInRoute() throws Exception {

        StationDao stationDao = mock(StationDao.class);
        StationServiceImpl stationService = new StationServiceImpl();
        Route route  = mock(Route.class);
        Train train = mock(Train.class);
        Station stationStart = mock(Station.class);
        Station stationFinish = mock(Station.class);

        when(route.getStartStation()).thenReturn(stationStart);
        when(route.getFinishStation()).thenReturn(stationFinish);

        List<String> strings = Arrays.asList("3","4");

        Station station3 = mock(Station.class);
        Station station4 = mock(Station.class);

        when(stationDao.read(3)).thenReturn(station3);
        when(stationDao.read(4)).thenReturn(station4);

        stationService.setStationDao(stationDao);

        List<Station> expected = new ArrayList<>();
        expected.add(stationStart);
        expected.add(station3);
        expected.add(station4);
        expected.add(stationFinish);

        assertEquals(stationService.checkStationsInRoute(route,strings),expected);


    }

}
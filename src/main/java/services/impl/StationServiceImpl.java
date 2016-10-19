package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.StationDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Station;
import services.api.StationService;

import java.util.List;

/**
 * Created by abalaev on 06.10.2016.
 */
public class StationServiceImpl implements StationService {

    private static final Logger LOG = Logger.getLogger(StationServiceImpl.class);
    private StationDao stationDao = FactoryDao.getStationDao();

    @Override
    public List<Station> getAllStations() {
        return stationDao.getAll();
    }

    @Override
    public Station read(int id) {
       Station result = null;
        result =  stationDao.read(id);
        return result;
    }

    @Override
    public Station createStation(Station station) {
        Station result = null;
            result = stationDao.create(station);
            LOG.info("station created {}", result);
        return result;
    }

    @Override
    public Station updateStation(Station station) {
       Station result = null;
            result = stationDao.update(station);
            LOG.info("station updated {}", result);
        return result;
    }
}

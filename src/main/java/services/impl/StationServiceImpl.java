package services.impl;

import persistence.DaoException;
import persistence.dao.api.StationDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Station;
import persistence.entities.Timetable;
import services.api.StationService;

import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 06.10.2016.
 */
public class StationServiceImpl implements StationService {

    private StationDao stationDao = FactoryDao.getStationDao();

    @Override
    public List<Station> getAllStations() {
        return stationDao.getAll();
    }

    @Override
    public Station read(int id) {
       Station result = null;
        try {
            result =  stationDao.read(id);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Station createStation(Station station) {
        Station result = null;
        try {
            result = stationDao.create(station);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Station updateStation(Station station) {
       Station result = null;
        try {
            result = stationDao.update(station);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return result;
    }
}

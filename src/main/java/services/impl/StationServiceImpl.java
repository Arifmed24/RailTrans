package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.StationDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Route;
import persistence.entities.Station;
import services.api.StationService;

import java.util.ArrayList;
import java.util.List;

public class StationServiceImpl implements StationService {

    private static final Logger LOG = Logger.getLogger(StationServiceImpl.class);
    private StationDao stationDao = FactoryDao.getStationDao();

    /**
     * get all stations
     * @return  list of stations
     */
    public List<Station> getAllStations() {
        return stationDao.getAll();
    }

    /**
     * get station by id
     * @param id    id
     * @return      station
     */
    public Station read(int id) {
       Station result;
        result =  stationDao.read(id);
        return result;
    }

    public Station createStation(Station station) {
        Station result;
            result = stationDao.create(station);
            LOG.info("station created {}", result);
        return result;
    }

    public Station updateStation(Station station) {
       Station result;
            result = stationDao.update(station);
            LOG.info("station updated {}", result);
        return result;
    }


    /**
     * check order and frequency of stations in route
     * @param route         route
     * @param stationsId    string stations
     * @return              stations
     * @throws Exception    wrong order
     */
    public List<Station> checkStationsInRoute(Route route, List<String> stationsId) throws Exception {
        LOG.info("start checking stations in route");
        List<Station> result = new ArrayList<>();
        result.add(route.getStartStation());
        result.add(route.getFinishStation());
        for (String stationId : stationsId) {
            int idStation = Integer.parseInt(stationId);
            Station nextStation = stationDao.read(idStation);
            if (!result.contains(nextStation)){
                result.add(result.size()-1,nextStation);
            } else {
                LOG.error("Route has one station more than one time");
                throw new Exception("Route can't have one station twice");
            }
        }
        LOG.info("finish checking stations in route");
        return result;
    }

    public void setStationDao(StationDao stationDao) {
        this.stationDao = stationDao;
    }
}

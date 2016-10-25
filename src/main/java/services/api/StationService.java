package services.api;

import persistence.entities.Route;
import persistence.entities.Station;

import java.util.List;

public interface StationService {
    List<Station> getAllStations();
    Station read(int id);
    Station createStation(Station station);
    Station updateStation(Station station);
    List<Station> checkStationsInRoute (Route route, List<String> stationsId) throws Exception;
}

package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.TimetableDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Route;
import persistence.entities.Station;
import persistence.entities.Timetable;
import services.api.TimetableService;

import java.util.ArrayList;
import java.util.List;

public class TimetableServiceImpl implements TimetableService {
    TimetableDao timetableDao = FactoryDao.getTimetableDao();
    private static final Logger LOG = Logger.getLogger(TimetableServiceImpl.class);

    public Timetable readByStations(Station stationBegin, Station stationEnd) throws Exception {
        LOG.info("start reading timetable by stations");
        Timetable result = timetableDao.readByStations(stationBegin, stationEnd);
        if (result != null) {
            LOG.info("finish reading timetable by stations");
            return result;
        } else{
            LOG.warn("timetable doesn't exist");
            throw new Exception("Way between " + stationBegin.getStationName()+ " and " + stationEnd.getStationName() + " doesn't exists");
        }
    }
}

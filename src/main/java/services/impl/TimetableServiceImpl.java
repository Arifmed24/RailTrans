package services.impl;

import persistence.dao.api.TimetableDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Route;
import persistence.entities.Station;
import persistence.entities.Timetable;
import services.api.TimetableService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abalaev on 07.10.2016.
 */
public class TimetableServiceImpl implements TimetableService {
    TimetableDao timetableDao = FactoryDao.getTimetableDao();

    @Override
    public List<Timetable> createTimetablesOfRoute(Route route, Timetable... timetables) {
       List<Timetable> timetableList = new ArrayList<>();

        return null;
    }

    @Override
    public List<Timetable> createTimetableList(List<Station> stations) {
        List<Timetable> timetables = new ArrayList<>();
        for (int i = 0; i < stations.size(); i++) {

        }
        return null;
    }
}

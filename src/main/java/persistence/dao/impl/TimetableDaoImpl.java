package persistence.dao.impl;

import persistence.dao.api.TimetableDao;
import persistence.entities.Station;
import persistence.entities.Timetable;

import javax.persistence.Query;

public class TimetableDaoImpl extends GenericDaoImpl<Timetable> implements TimetableDao {
    /**
     * get way connecting two stations
     * @param stationBegin      begin station
     * @param stationEnd        end station
     * @return                  timetable
     */
    public Timetable readByStations(Station stationBegin, Station stationEnd) {
        Query query = em.createNamedQuery("Timetable.readByStations", Timetable.class);
        query.setParameter("begin", stationBegin);
        query.setParameter("end", stationEnd);
        try {
            return (Timetable) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}

package persistence.dao.impl;

import persistence.DaoException;
import persistence.dao.api.TimetableDao;
import persistence.entities.Station;
import persistence.entities.Timetable;

import javax.persistence.TypedQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class TimetableDaoImpl extends GenericDaoImpl<Timetable> implements TimetableDao {
    @Override
    public List<Timetable> getStationTimetable(Station station, Date date) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String datetime1 = sdf.format(date)+" 00:00:00";
        String datetime2 = sdf.format(date)+ " 23:59:59";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = formatter.parse(datetime1);
            date2 = formatter.parse(datetime2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TypedQuery<Timetable> query;
            query = em.createNamedQuery("Timetable.getStationTimetable", Timetable.class);
            query.setParameter("station",station);
            query.setParameter("datetime",date1);
            query.setParameter("datetime2",date2);
            return query.getResultList();
    }



}

package services.impl;

import org.apache.commons.lang.time.DateUtils;
import persistence.dao.api.RouteTimetablesDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.RouteTimetables;
import persistence.entities.Station;
import services.api.RouteTimatablesService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by abalaev on 06.10.2016.
 */
public class RouteTimetableServiceImpl implements RouteTimatablesService {

    RouteTimetablesDao routeTimetablesDao = FactoryDao.getRouteTimetablesDao();

    public List<RouteTimetables> getTimetableStation(Station station, Date date) {

       //list of all route_timetables
        List<RouteTimetables> routeTimetables = routeTimetablesDao.getAll();
        List<RouteTimetables> result = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String datetime1 = sdf.format(date)+" 00:00:00"; //2016-10-15 00:00:00
//        String datetime1 = sdf.format(date);
//        String datetime2 = sdf.format(date)+ " 23:59:59"; //2016-10-15 23:59:59
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = null;
//        Date date2 = null;
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());




        for (RouteTimetables r: routeTimetables) {
            if (timestamp.before(r.getDateArrival()))
            result.add(r);
        }
//if (timestamp.before(r.getDateArrival()))
//                result.add(r);
//            if (r.getLine().getStationDeparture() == station && timestamp.before(r.getDateDeparture()) && timestamp2.after(r.getDateDeparture()))
//                result.add(r);
        return routeTimetables;
        }

    }


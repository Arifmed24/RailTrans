package services.impl;

import persistence.dao.api.TimetableDao;
import persistence.dao.impl.FactoryDao;
import services.api.TimetableService;

/**
 * Created by abalaev on 07.10.2016.
 */
public class TimetableServiceImpl implements TimetableService {
    TimetableDao timetableDao = FactoryDao.getTimetableDao();
}

package services.impl;

import persistence.dao.api.PassengerDao;
import persistence.dao.impl.FactoryDao;
import services.api.PassengerService;

/**
 * Created by abalaev on 07.10.2016.
 */
public class PassengerServiceImpl implements PassengerService {
    PassengerDao passengerDao = FactoryDao.getPassengerDao();
}

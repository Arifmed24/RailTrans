package services.impl;

import persistence.DaoException;
import persistence.dao.api.TrainDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Train;
import services.api.TrainService;

/**
 * Created by abalaev on 07.10.2016.
 */
public class TrainServiceImpl implements TrainService {

    private TrainDao trainDao = FactoryDao.getTrainDao();
    @Override
    public Train createTrain(Train train) {
        Train result = null;
        try {
            result = trainDao.create(train);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return result;
    }
}

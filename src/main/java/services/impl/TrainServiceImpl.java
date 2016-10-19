package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.TrainDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Train;
import services.api.TrainService;

/**
 * Created by abalaev on 07.10.2016.
 */
public class TrainServiceImpl implements TrainService {

    private static final Logger LOG = Logger.getLogger(TrainServiceImpl.class);
    private TrainDao trainDao = FactoryDao.getTrainDao();
    @Override
    public Train createTrain(Train train) {
        Train result = null;
            result = trainDao.create(train);
            LOG.info("train created {}",result);
        return result;
    }
}

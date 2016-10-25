package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.TrainDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.Train;
import services.api.TrainService;

import java.util.List;

/**
 * Created by abalaev on 07.10.2016.
 */
public class TrainServiceImpl implements TrainService {

    private static final Logger LOG = Logger.getLogger(TrainServiceImpl.class);
    private TrainDao trainDao = FactoryDao.getTrainDao();

    public Train createTrain(Train train) {
        Train result = null;
            result = trainDao.create(train);
            LOG.info("train created {}",result);
        return result;
    }

    public List<Train> getAllTrains() {
        LOG.info("get list of all trains");
        return trainDao.getAllTrains();
    }

    public Train read(int id) {
        Train result = null;
        result = trainDao.read(id);
        LOG.info("read train by id {}", result);
        return result;
    }
}

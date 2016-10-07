package persistence.dao.api;

import persistence.entities.Train;

import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface TrainDao extends GenericDao<Train>  {
    List<Train> getAllTrains();
}

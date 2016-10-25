package services.api;

import persistence.entities.Train;

import java.util.List;

public interface TrainService {
    Train createTrain(Train train);
    List<Train> getAllTrains();
    Train read(int id);
}

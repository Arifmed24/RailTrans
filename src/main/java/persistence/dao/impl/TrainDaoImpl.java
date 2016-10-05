package persistence.dao.impl;

import persistence.dao.api.TrainDao;
import persistence.entities.Train;

import javax.persistence.Query;

/**
 * Created by abalaev on 30.09.2016.
 */
public class TrainDaoImpl extends GenericDaoImpl<Train> implements TrainDao {
//    @Override
//    public Train findTrainByTimetable(int idTmtbl) {
//        Query query = em.createNamedQuery("Train.findTrainByTimetable",Train.class);
//        query.setParameter("idTmtbl",idTmtbl);
////        em.close();
//        return (Train) query.getSingleResult();
//    }
}

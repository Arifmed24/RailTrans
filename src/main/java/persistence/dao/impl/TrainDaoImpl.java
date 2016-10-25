package persistence.dao.impl;

import persistence.dao.api.TrainDao;
import persistence.entities.Train;

import javax.persistence.TypedQuery;
import java.util.List;

public class TrainDaoImpl extends GenericDaoImpl<Train> implements TrainDao {
    /**
     * get list of all trains
     * @return      list of trains
     */
    public List<Train> getAllTrains() {
        List<Train> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Train> query;
            query = em.createNamedQuery("Train.getAllTrains",Train.class);
            result = query.getResultList();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        return result;
    }
}

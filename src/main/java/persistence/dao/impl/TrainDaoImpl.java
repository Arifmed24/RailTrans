package persistence.dao.impl;

import persistence.dao.api.TrainDao;
import persistence.entities.Train;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class TrainDaoImpl extends GenericDaoImpl<Train> implements TrainDao {
    @Override
    public List<Train> getAllTrains() {
        List<Train> result = null;
        try {
            em.getTransaction().begin();
            TypedQuery<Train> query = null;
            query = em.createNamedQuery("Train.getAllTrains",Train.class);
            result = query.getResultList();
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        return result;
    }
}

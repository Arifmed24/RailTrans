package persistence.dao.impl;



import persistence.DaoException;
import persistence.dao.api.GenericDao;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by abalaev on 28.09.2016.
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

//    private static final Logger LOG = Logger.getLogger(GenericDaoImpl.class);

    public Class<T> type;

    protected String entityName = "";

    protected EntityManager em ;
//    =  Persistence.createEntityManagerFactory("Rail").createEntityManager();

    public GenericDaoImpl(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Rail");
        em = factory.createEntityManager();
        this.type = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.entityName = type.getSimpleName();
    }

    @Override
    public T create(T entity) throws DaoException{
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
//           LOG.error("Unexpected DB exception", e);
            throw new DaoException(e);
        }
        return entity;
    }

    @Override
    public T update(T entity) throws DaoException {
       T result = null;
        try {
            em.getTransaction().begin();
            result = em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
//            LOG.error("Unexpected DB exception", e);
            throw new DaoException(e);
        }
        return result;
    }

    @Override
    public void delete(T entity) throws DaoException {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
//            LOG.error("Unexpected DB exception", e);
            throw new DaoException(e);
        }
    }

    @Override
    public T read(int id) throws DaoException{
        T result = null;
        try {
           em.getTransaction().begin();
            result = em.find(type,id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
//            LOG.error("Unexpected DB exception", e);
            throw new DaoException(e);
        }
        return result;
    }
}

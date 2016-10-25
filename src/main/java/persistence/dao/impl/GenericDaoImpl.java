package persistence.dao.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.GenericDao;
import javax.persistence.*;
import java.lang.reflect.ParameterizedType;


abstract class GenericDaoImpl<T> implements GenericDao<T> {

    private static final Logger LOG = Logger.getLogger(GenericDaoImpl.class);

    public Class<T> type;

    protected String entityName = "";

    protected EntityManager em ;

    public GenericDaoImpl(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Rail");
        em = factory.createEntityManager();
        this.type = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        this.entityName = type.getSimpleName();
    }

    @Override
    public T create(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
           LOG.error("Unexpected DB exception in create entity", e);
        }
        return entity;
    }

    @Override
    public T update(T entity) {
       T result = null;
        try {
            em.getTransaction().begin();
            result = em.merge(entity);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            LOG.error("Unexpected DB exception in update entity", e);
        }
        return result;
    }

    @Override
    public void delete(T entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            LOG.error("Unexpected DB exception in delete entity", e);
        }
    }

    @Override
    public T read(int id) {
        T result = null;
        try {
           em.getTransaction().begin();
            result = em.find(type,id);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            LOG.error("Unexpected DB exception in read entity", e);
        }
        return result;
    }
}

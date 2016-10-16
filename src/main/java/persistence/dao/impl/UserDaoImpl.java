package persistence.dao.impl;

import org.apache.log4j.Logger;
import persistence.DaoException;
import persistence.dao.api.UserDao;
import persistence.entities.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User findByLogin(String login) throws DaoException {
        Query query = null;
        try {
            query = em.createNamedQuery("User.findByLogin", User.class);
            query.setParameter("login", login);
        } catch (Exception e) {
            LOG.error("Unexpected DB exception", e);
            throw new DaoException(e);
        }
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> findAll() throws DaoException {
        TypedQuery<User> query;
        try {
            query = em.createNamedQuery("User.findAll", User.class);
            return query.getResultList();
        } catch (
                Exception e) {
            LOG.error("Unexpected DB exception", e);
            throw new DaoException(e);
        }
    }

        @Override
        public User userLogin (String login, String password){
            Query query = em.createNamedQuery("User.login",User.class);
            query.setParameter("login",login);
            query.setParameter("password",password);
            return (User) query.getSingleResult();
        }


}



    //    @Override
//    public List<User> getAll() throws SQLException {
//        List<User> result = null;
//        try {
//            em.getTransaction().begin();
//            Query query = em.createQuery("select e from Module e");
//            result = query.getResultList();
//            em.getTransaction().commit();
//        } catch (Exception e){
//            em.getTransaction().rollback();
//        }
//        return result;
//    }

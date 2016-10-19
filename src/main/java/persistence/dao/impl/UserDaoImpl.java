package persistence.dao.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.UserDao;
import persistence.entities.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    @Override
    public User findByLogin(String login) {
        Query query = null;
            query = em.createNamedQuery("User.findByLogin", User.class);
            query.setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> findAll(){
        TypedQuery<User> query = null;
        try {
            query = em.createNamedQuery("User.findAll", User.class);
        } catch (
                Exception e) {
            LOG.error("Unexpected DB exception", e);
        }
        return query.getResultList();
    }

        @Override
        public User userLogin (String login, String password){
            Query query = em.createNamedQuery("User.login",User.class);
            query.setParameter("login",login);
            query.setParameter("password",password);
            return (User) query.getSingleResult();
        }


}
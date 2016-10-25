package persistence.dao.impl;


import persistence.dao.api.UserDao;
import persistence.entities.User;

import javax.persistence.Query;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    /**
     * get user by login
     * @param login     login
     * @return          user
     */
    public User findByLogin(String login) {
        Query query;
            query = em.createNamedQuery("User.findByLogin", User.class);
            query.setParameter("login", login);
        return (User) query.getSingleResult();
    }

    /**
     * log in user by login and password
     * @param login     login
     * @param password  password
     * @return          user
     */
    public User userLogin (String login, String password){
        Query query = em.createNamedQuery("User.login",User.class);
        query.setParameter("login",login);
        query.setParameter("password",password);
        return (User) query.getSingleResult();
    }
}
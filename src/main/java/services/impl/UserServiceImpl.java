package services.impl;

import org.apache.log4j.Logger;
import persistence.dao.api.UserDao;
import persistence.dao.impl.FactoryDao;
import persistence.entities.User;
import services.ServiceException;
import services.api.UserService;

import javax.persistence.NoResultException;

public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);
    private UserDao userDao = FactoryDao.getUserDao();

    public User findUserByLogin(String login) throws ServiceException {
        User user = null;
        try {
              user = userDao.findByLogin(login);
            } catch (NoResultException nre){
            }
            if (user == null) {
                LOG.info("user not found in database");
                return null;
            }
            return user;
    }

    public User login(String login, String password) throws ServiceException {
        LOG.info("user login");
        User result = null;
        try {
            result = userDao.userLogin(login,password);
        } catch (Exception e) {
            throw new ServiceException("Unknown exception", e);
        }
        return result;
    }

    public boolean register(User user){
        LOG.info("user registration");
        User findUser = null;
        try {
            findUser = findUserByLogin(user.getLogin());
        } catch (ServiceException e) {
            e.printStackTrace();
            LOG.error("Error in finding user by login", e);
        }
        if (findUser == null){
            userDao.create(user);
            LOG.info("new user created");
            return true;
        } else {
            LOG.info("this user is registered yet");
            return false;
        }
    }
}

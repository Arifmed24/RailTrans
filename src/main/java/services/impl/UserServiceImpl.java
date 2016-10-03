package services.impl;

//import org.apache.log4j.Logger;
import persistence.DaoException;
import persistence.dao.api.UserDao;
import persistence.dao.impl.UserDaoImpl;
import persistence.entities.User;
import services.ServiceException;
import services.api.UserService;

/**
 * Created by abalaev on 01.10.2016.
 */

public class UserServiceImpl implements UserService {

//    private static Logger LOG = Logger.getLogger(UserService.class);
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findUserByLogin(String login) throws ServiceException {
        try {
            User user = userDao.findByLogin(login);
            if (user == null) {
                throw new ServiceException("User not found");
            }
            return user;
        } catch (DaoException e) {
//            LOG.warn(e.getMessage());
            throw new ServiceException("Unknown exception", e);
        }
    }

    @Override
    public User login(String login, String password) throws ServiceException {
        User result = null;
        try {
            result = userDao.userLogin(login,password);
        } catch (Exception e) {
//            LOG.warn(e.getMessage());
            throw new ServiceException("Unknown exception", e);
        }
        return result;
    }

    public boolean register(User user){
        try {
            userDao.create(user);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }
}
package services.api;

import persistence.entities.User;
import services.ServiceException;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface UserService {
    User findUserByLogin(String login) throws ServiceException;
    User login (String login, String password) throws ServiceException;
    boolean register(User user);
}

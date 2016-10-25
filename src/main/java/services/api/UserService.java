package services.api;

import persistence.entities.User;
import services.ServiceException;

public interface UserService {
    User findUserByLogin(String login) throws ServiceException;
    User login (String login, String password) throws ServiceException;
    boolean register(User user);
}

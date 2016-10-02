package persistence.dao.api;

import persistence.DaoException;
import persistence.entities.User;

import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface UserDao extends GenericDao<User> {
    User findByLogin(String login) throws DaoException;
    List<User> findAll() throws DaoException;
    User userLogin(String login, String password);
}

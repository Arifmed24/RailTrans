package persistence.dao.api;

import persistence.DaoException;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by abalaev on 28.09.2016.
 */
public interface GenericDao<T> {

    T create(T entity) throws DaoException;
    T read(int id) throws DaoException;
    T update(T entity) throws DaoException;
    void delete(T entity) throws DaoException;
}

package persistence.dao.api;


/**
 * Created by abalaev on 28.09.2016.
 */
public interface GenericDao<T> {

    T create(T entity);
    T read(int id);
    T update(T entity);
    void delete(T entity);
}

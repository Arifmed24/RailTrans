package services.api;

import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface GenericService<T> {
    T createEntity(T entity);
    T readEntity(int id);
    T updateEntity(T entity);
    void deleteEntity(T entity);
}

package persistence.dao.api;


import persistence.entities.Route;

import java.util.List;

/**
 * Created by abalaev on 30.09.2016.
 */
public interface RouteDao extends GenericDao<Route> {
    List<Route> getAll();
}
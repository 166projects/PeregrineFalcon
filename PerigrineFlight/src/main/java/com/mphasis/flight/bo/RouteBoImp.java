package com.mphasis.flight.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.flight.dao.RouteDao;
import com.mphasis.flight.entities.Route;
import com.mphasis.flight.exceptions.BusinessException;


@Service
public class RouteBoImp implements RouteBo {
@Autowired
        RouteDao routeDao;
	public List<Route> getRoutes() {
	List<Route>routes=routeDao.getRoutes();
	try {
    if(routes.isEmpty()) {
	throw new BusinessException("No Route");	
	}
	}catch(BusinessException e) {
		e.printStackTrace();
	}
		return routes;
	}

	public void insertRoute(Route route) {
     routeDao.addRoute(route);
		
	}

	public void editRoute(Route route) {
		routeDao.updateRoute(route);
	
		
	}

	public void removeRoute(String rid) {
	    routeDao.deleteRoute(rid);
		
	}

	public List<Route> getBySource(String source) throws BusinessException{
		if(source.isEmpty()) {
			
			throw new BusinessException("No Source");
		}
	       
		return routeDao.getBySource(source);
	}

	public List<Route> getByDestination(String destination) throws BusinessException {
		if(destination.isEmpty()) {
			
			throw new BusinessException("No Destination");
		}
		
		return routeDao.getByDestination(destination);
	}
	
	public List<Route> getBySourceDestination(String source, String destination) {
        // TODO Auto-generated method stub
        return routeDao.getBySourceDestination(source, destination);
          }


}

package com.mphasis.flight.bo;

import java.util.List;

import com.mphasis.flight.entities.Route;
import com.mphasis.flight.exceptions.BusinessException;

public interface RouteBo {
	public List<Route> getRoutes();
	public void insertRoute(Route route);
	public void editRoute(Route route);
	public void removeRoute(int rid);
	public List<Route> getBySource(String source) throws BusinessException;
	public List<Route> getByDestination(String destination) throws BusinessException;

}
 

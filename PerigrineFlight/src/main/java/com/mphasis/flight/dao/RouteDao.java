package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.Route;

public interface RouteDao {
	public List<Route> getRoutes();
	public void addRoute(Route route);
	public  void updateRoute(Route route); 		
	public void deleteRoute(int rid);
	public List<Route> getBySource(String source);
 	public List<Route> getByDestination(String destination);

}


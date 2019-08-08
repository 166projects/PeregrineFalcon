package com.mphasis.flight.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.flight.entities.Route;



@Repository
public class RouteDaoImp implements RouteDao {
	@Autowired
    SessionFactory sessionFactory;
	public List<Route> getRoutes() {
		Session session=sessionFactory.openSession();
		List<Route> routes=session.createCriteria(Route.class).list();
		return routes;
	}

	public void addRoute(Route route) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(route);
        tr.commit();
        
		
	}

	public void updateRoute(Route route) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(route);
		tr.commit();
		

		
	}

	public void deleteRoute(int rid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Route r=(Route) session.get(Route.class,rid);
		session.delete(r);
		tr.commit();
		session.close();
		

		
	}

	public List<Route> getBySource(String source) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Route> r=null;
		r=(List<Route>)session.get(Route.class,source);
		return r;
	}

	public List<Route> getByDestination(String destination) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Route> r=null;
		r=(List<Route>)session.get(Route.class,destination);
		return r;
	}

	
}

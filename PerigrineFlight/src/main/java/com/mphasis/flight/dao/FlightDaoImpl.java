package com.mphasis.flight.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mphasis.flight.entities.Flight;
import com.mphasis.flight.entities.Fuser;

@Repository
public class FlightDaoImpl implements FlightDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public void addFlight(Flight flight) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(flight);
		tr.commit();
		
	}

	public void updateFlight(Flight flight) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(flight);
		tr.commit();
		
	}

	public void deleteFlight(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Flight flight=(Flight) session.get(Flight.class, id);
		session.delete(flight);
		tr.commit();
		
	}

	public List<Flight> getAllFlights() {
		Session session=sessionFactory.openSession();
		List<Flight> flights= session.createCriteria(Flight.class).list();
		return flights;
	}

	public Flight getById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Flight flight=(Flight) session.get(Flight.class, id);
		tr.commit();
		return flight;
	}
	
	
	
	


}

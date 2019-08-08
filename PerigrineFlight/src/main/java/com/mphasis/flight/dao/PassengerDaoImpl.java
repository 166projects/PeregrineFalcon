package com.mphasis.flight.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mphasis.flight.entities.Flight;
import com.mphasis.flight.entities.Passenger;
@Repository
public class PassengerDaoImpl implements PassengerDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public List<Passenger> getPassengers() {
		Session session=sessionFactory.openSession();
		List<Passenger> passengers= session.createCriteria(Passenger.class).list();
		return passengers;
	}

	public List<Passenger> getByName(String name) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Passenger> pass = session.createCriteria(Passenger.class).add(Restrictions.eq("name",name)).list();
				tr.commit();
		return pass;
	}

	public List<Passenger> getByGender(String gender) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Passenger> pass = session.createCriteria(Passenger.class).add(Restrictions.eq("gender",gender)).list();
				tr.commit();
				return pass;
	}

	public List<Passenger> getByAge(int age) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Passenger> pass = session.createCriteria(Passenger.class).add(Restrictions.eq("age",age)).list();
				tr.commit();
				return pass;
	
	}

	public void updatePassenger(Passenger passenger) {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(passenger);
		tr.commit();
	}

	public void addPassenger(Passenger passenger) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(passenger);
		tr.commit();
		
	}

	public void deletePassenger(int id) {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Passenger passenger= (Passenger) session.get(Passenger.class, id);
		session.delete(passenger);
		tr.commit();
		
	}

}

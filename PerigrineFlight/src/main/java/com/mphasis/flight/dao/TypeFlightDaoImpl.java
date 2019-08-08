package com.mphasis.flight.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.flight.dao.TypeFlightDao;
import com.mphasis.flight.entities.Passenger;
import com.mphasis.flight.entities.TypeFlight;
@Repository
public class TypeFlightDaoImpl implements TypeFlightDao {

	@Autowired
	SessionFactory sessionFactory;
	public String getByTypeofSeat(TypeFlight typeflight) {
		return typeflight.getTypeofseat();
		
	}
//	public int getNoofAvailableSeats(String typeofseat) {
//		return 0;
//		
//	}

}

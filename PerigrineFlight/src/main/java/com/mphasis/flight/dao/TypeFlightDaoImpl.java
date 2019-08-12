package com.mphasis.flight.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.flight.dao.TypeFlightDao;
import com.mphasis.flight.entities.Schedule;
import com.mphasis.flight.entities.TypeFlight;
@Repository
public class TypeFlightDaoImpl implements TypeFlightDao {

	@Autowired
	SessionFactory sessionFactory;

	public void addTypeFlight(TypeFlight typeflight) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(typeflight);
		tr.commit();
		
	}

	public List<TypeFlight> getNoofSeats(String typeofseat,int fid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		
		List<TypeFlight> typeflight=session.createCriteria(TypeFlight.class).add(Restrictions.eq("typeofseat",typeofseat)).list();	
		
		
		/*String noofseats=typeflight.get(type.getNoofseats()).toString();
		String bookedseats=typeflight.get(type.getBookedseats()).toString();
		int available=Integer.parseInt(noofseats)-Integer.parseInt(bookedseats);*/
		return typeflight;
		
	}
	
	public TypeFlight getById(int tfid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		TypeFlight typeflight=session.get(TypeFlight.class, tfid);
		return typeflight;
	}
}

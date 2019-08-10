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

	public int getNoofSeats(String typeofseat) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
//		@SuppressWarnings("deprecation")
//		TypeFlight typeflight= (TypeFlight) session.createCriteria(TypeFlight.class).add(Restrictions.eq("typeofseat",typeofseat));
//		
//		String s=typeflight.toString();
//		tr.commit();
//		return s;
	String noofseats = (String) session.createQuery("select noofseats from typeflight t where t.typeofseat = :typeofseat").setParameter("typeofseat",typeofseat).uniqueResult();
		return Integer.parseInt(noofseats);
	}
	

}

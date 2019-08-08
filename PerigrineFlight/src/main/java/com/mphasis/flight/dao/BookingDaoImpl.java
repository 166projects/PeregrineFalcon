package com.mphasis.flight.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.flight.entities.Booking;


@Repository
public class BookingDaoImpl implements BookingDao{
	
	@Autowired
	SessionFactory sessionfactory;
	
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(booking);
		tr.commit();
	}

	public void deleteBooking(Booking booking) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(booking);
		tr.commit();
	}

	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Booking> booking=null;
		booking=session.createCriteria(Booking.class).list();
		tr.commit();
		return booking;
	}

	public Booking getById(int bid) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Booking booking=null;
		booking= (Booking) session.get(Booking.class, bid);
		tr.commit();
		return booking;
	}

}

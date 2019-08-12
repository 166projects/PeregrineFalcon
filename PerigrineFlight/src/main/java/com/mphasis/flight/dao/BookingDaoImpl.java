package com.mphasis.flight.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.flight.entities.Booking;
import com.mphasis.flight.entities.Flight;
import com.mphasis.flight.entities.Schedule;
import com.mphasis.flight.entities.TypeFlight;


@Repository
public class BookingDaoImpl implements BookingDao{
	
	@Autowired
	SessionFactory sessionfactory;

	Flight flight;
	
	TypeFlight typeflight;

	Schedule schedule;

	List<Booking> booking;
	
	Booking booking1;
	 
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(booking);
		
	
		TypeFlight tf=  booking.getTypeflight();
		int seatsBooked=tf.getBookedseats();
		if(seatsBooked>0) {
			seatsBooked+=1;
		}else {
			throw new RuntimeException("ticket not booked");
		}
		tf.setBookedseats(seatsBooked);
		session.update(tf);
		tr.commit();
	}

	public void deleteBooking(int bid) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Booking booking= session.get(Booking.class, bid);
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

	public int getTotalFare(String bid) {
		Session session=sessionfactory.openSession();
        Transaction tr=session.beginTransaction();
        //System.out.println("salary increment");
       
       booking= session.createCriteria(Booking.class).add(Restrictions.eq("bid",bid)).list();
       
      booking1=booking.get(0);
       typeflight=booking1.getTypeflight();
       schedule=booking1.getSchedule();
            
        flight=schedule.getFlight();
        System.out.println("dis-"+flight.getDistance());
        System.out.println("typeofseat-"+typeflight.getTypeofseat());
        System.out.println("arrivaltime-"+schedule.getArrival());
        System.out.println("departuretime-"+schedule.getDeparture());
        ProcedureCall count =  session.createStoredProcedureCall("total_fare_cal");
        count.registerParameter("distance", Integer.class, ParameterMode.IN).bindValue(flight.getDistance());
        count.registerParameter("typeofseat", String.class, ParameterMode.IN).bindValue(typeflight.getTypeofseat());
        count.registerParameter("arr", String.class, ParameterMode.IN).bindValue(schedule.getArrival());
        count.registerParameter("departure", String.class, ParameterMode.IN).bindValue(schedule.getDeparture());
        count.registerParameter("totalfare", Integer.class, ParameterMode.OUT);
        ProcedureOutputs procedureResult=count.getOutputs();
        int fare_cal=(int) procedureResult.getOutputParameterValue("totalfare");
        session.update(fare_cal);
        System.out.print(fare_cal);
        tr.commit();
		return fare_cal;
	}

}

package com.mphasis.flight.dao;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.flight.entities.Passenger;
import com.mphasis.flight.entities.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addSchedule(Schedule schedule) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(schedule);
		tr.commit();
		/*Date instant= schedule.getArrival();
		String t=instant.toString();
		Date dep=schedule.getDeparture();
		String de=dep.toString();
		try {
			Date fmt=new SimpleDateFormat("HH:mm").parse(t);
			Date fmt1=new SimpleDateFormat("HH:mm").parse(de);
			schedule.setArrival(fmt);
			schedule.setDeparture(fmt1);
			System.out.println("dao of arrival"+fmt+" "+fmt1);
			session.save(schedule);
			tr.commit();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}

	public void updateSchedule(Schedule schedule) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(schedule);
		tr.commit();

	}

	public void deleteSchedule(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Schedule st= (Schedule) session.get(Schedule.class, id);
		session.delete(st);
		tr.commit();

	}

	public List<Schedule> getSchedules() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List <Schedule> schedules=session.createCriteria(Schedule.class).list(); 
		return schedules;
	}

	public Schedule getScheduleById(int id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Schedule sc= (Schedule) session.get(Schedule.class, id);
		//tr.commit();

		return sc;
	}

	public List<Schedule> getScheduleByDate(String fdate) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Schedule> sc=session.createCriteria(Schedule.class).add(Restrictions.eq("fdate",fdate)).list();
		tr.commit();

		return sc;
	}

	public List<Schedule> getScheduleByArrival(String arrival) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Schedule> sc= session.createCriteria(Schedule.class).add(Restrictions.eq("arrival",arrival)).list();
		tr.commit();

		return sc;
	}

	public List<Schedule> getScheduleByDeparture(String departure) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Schedule> sc= session.createCriteria(Schedule.class).add(Restrictions.eq("departure",departure)).list();
		tr.commit();

		return sc;
	}

	
	

}

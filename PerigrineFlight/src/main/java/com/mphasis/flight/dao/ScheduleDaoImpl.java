package com.mphasis.flight.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		tr.commit();

		return sc;
	}

	public Schedule getScheduleByDate(LocalDate fdate) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Schedule sc= (Schedule) session.get(Schedule.class, fdate);
		tr.commit();

		return sc;
	}

	public Schedule getScheduleByArrival(LocalTime arrival) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Schedule sc= (Schedule) session.get(Schedule.class, arrival);
		tr.commit();

		return sc;
	}

	public Schedule getScheduleByDeparture(LocalTime departure) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Schedule sc= (Schedule) session.get(Schedule.class, departure);
		tr.commit();

		return sc;
	}
	

}

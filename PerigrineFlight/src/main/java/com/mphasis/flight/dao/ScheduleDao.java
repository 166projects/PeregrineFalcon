package com.mphasis.flight.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.mphasis.flight.entities.Schedule;

public interface ScheduleDao {
	
	public void addSchedule(Schedule schedule);
	public void updateSchedule(Schedule schedule);
	public void deleteSchedule(int id);
	public List<Schedule> getSchedules();
	public Schedule getScheduleById(int id);
	public Schedule getScheduleByDate(LocalDate fdate);
	public Schedule getScheduleByArrival(LocalTime arrival);
	public Schedule getScheduleByDeparture(LocalTime departure);
}

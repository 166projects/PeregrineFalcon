package com.mphasis.flight.bo;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.mphasis.flight.entities.Schedule;

public interface ScheduleBo {
	
	public void addSchedule(Schedule schedule);
	public void updateSchedule(Schedule schedule);
	public void deleteSchedule(String id);
	public List<Schedule> getSchedules();
	public Schedule getScheduleById(String id);
	public List<Schedule> getScheduleByDate(String fdate);
	public List<Schedule> getScheduleByArrival(String arrival);
	public List<Schedule> getScheduleByDeparture(String departure);

}

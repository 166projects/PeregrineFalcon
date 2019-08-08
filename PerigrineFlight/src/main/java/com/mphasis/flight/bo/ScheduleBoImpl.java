package com.mphasis.flight.bo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.flight.exceptions.BusinessException;
import com.mphasis.flight.dao.ScheduleDao;
import com.mphasis.flight.entities.Schedule;

@Service
public class ScheduleBoImpl implements ScheduleBo {

	@Autowired
	ScheduleDao scheduleDao;

	public void addSchedule(Schedule schedule) {
//		Schedule sc= (Schedule) scheduleDao.getSchedules();
		
		scheduleDao.addSchedule(schedule);

	}

	public void updateSchedule(Schedule schedule) {
		scheduleDao.updateSchedule(schedule);

	}

	public void deleteSchedule(int id) {
		scheduleDao.deleteSchedule(id);

	}

	public List<Schedule> getSchedules() {
		List<Schedule> schedules = scheduleDao.getSchedules();
		if (schedules.isEmpty()) {
			try {
				throw new BusinessException("Oops looks like no schedule is present");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return schedules;
	}

	public Schedule getScheduleById(int id) {
		Schedule schedules = scheduleDao.getScheduleById(id);
		if (schedules == null) {
			try {
				throw new BusinessException("Oops looks like no schedule is present for the given Id");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return schedules;
	}

	public Schedule getScheduleByDate(LocalDate fdate) {
		Schedule schedules = scheduleDao.getScheduleByDate(fdate);
		LocalDate currentDate = LocalDate.now();
		if (fdate.isAfter(currentDate) || fdate.isEqual(currentDate)) {
			if (schedules == null) {
				try {
					throw new BusinessException("Oops looks like no schedule is present for the given Date");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			try {
				throw new BusinessException("Oops looks like you've entered a previous Date");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return schedules;
	}

	public Schedule getScheduleByArrival(LocalTime arrival) {
		Schedule schedules = scheduleDao.getScheduleByArrival(arrival);
		if (schedules == null) {
			try {
				throw new BusinessException("Oops looks like no schedule is present for the given Arrival Date");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return schedules;
	}

	public Schedule getScheduleByDeparture(LocalTime departure) {
		Schedule schedules = scheduleDao.getScheduleByDeparture(departure);
		if (schedules == null) {
			try {
				throw new BusinessException("Oops looks like no schedule is present for the given Departure Date");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return schedules;

	}
}

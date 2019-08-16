package com.mphasis.flight.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.flight.dao.FlightDao;
import com.mphasis.flight.entities.Flight;

@Service
public class FlightBoImpl implements FlightBo{
	@Autowired
	FlightDao flightDao;
	public void addFlight(Flight flight) {
		
		flightDao.addFlight(flight);
	}

	public void updateFlight(Flight flight) {
		flightDao.updateFlight(flight);
		
	}

	public void deleteFlight(String id) {
		flightDao.deleteFlight(id);
	}

	public List<Flight> getAllFlights() {
		
		return flightDao.getAllFlights();
	}

	public Flight getById(String id) {
		
		return flightDao.getById(id);
	}

}

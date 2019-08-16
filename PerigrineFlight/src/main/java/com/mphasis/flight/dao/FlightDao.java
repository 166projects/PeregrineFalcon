package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.Flight;

public interface FlightDao {
	
	public void addFlight(Flight flight);
	public void updateFlight(Flight flight);
	public void deleteFlight(String id);
	public List<Flight> getAllFlights();
	public Flight getById(String id);

}

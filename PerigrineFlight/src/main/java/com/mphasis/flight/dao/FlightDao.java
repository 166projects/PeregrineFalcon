package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.Flight;

public interface FlightDao {
	
	public void addFlight(Flight flight);
	public void updateFlight(Flight flight);
	public void deleteFlight(int id);
	public List<Flight> getAllFlights();
	public Flight getById(int id);

}

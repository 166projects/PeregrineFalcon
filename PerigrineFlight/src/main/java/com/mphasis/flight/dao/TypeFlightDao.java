package com.mphasis.flight.dao;

import com.mphasis.flight.entities.TypeFlight;

public interface TypeFlightDao {

	public void addTypeFlight(TypeFlight typeflight);
	public int getNoofSeats(String typeofseat);
	
}

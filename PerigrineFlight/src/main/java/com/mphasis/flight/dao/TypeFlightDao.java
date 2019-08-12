package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.TypeFlight;

public interface TypeFlightDao {

	public void addTypeFlight(TypeFlight typeflight);
	public List<TypeFlight> getNoofSeats(String typeofseat, int fid);
	public TypeFlight getById(int tfid);
}

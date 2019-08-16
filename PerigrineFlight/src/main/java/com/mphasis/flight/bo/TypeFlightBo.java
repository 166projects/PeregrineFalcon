package com.mphasis.flight.bo;

import java.util.List;

import com.mphasis.flight.entities.TypeFlight;

public interface TypeFlightBo {

	public void addTypeFlight(TypeFlight typeflight);
	public List<TypeFlight> getNoofSeats(String typeofseat, String fid);
	public TypeFlight getById(String tfid);
}

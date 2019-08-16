package com.mphasis.flight.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.flight.dao.TypeFlightDao;
import com.mphasis.flight.entities.TypeFlight;

@Service
public class TypeFlightBoImpl implements TypeFlightBo {

	@Autowired
	TypeFlightDao typeFlightDao;

	public void addTypeFlight(TypeFlight typeflight) {
		typeFlightDao.addTypeFlight(typeflight);
		
	}

	public List<TypeFlight> getNoofSeats(String typeofseat,String fid) {
		
		return typeFlightDao.getNoofSeats(typeofseat,fid);
	}
	
    public TypeFlight getById(String tfid) {
    	return typeFlightDao.getById(tfid);
    }
}

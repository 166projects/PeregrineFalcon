package com.mphasis.flight.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.flight.dao.TypeFlightDao;
import com.mphasis.flight.entities.TypeFlight;

@Service
public class TypeFlightBoImpl implements TypeFlightBo {

	@Autowired
	TypeFlightDao typeFlightDao;
	public String getByTypeofSeat(TypeFlight typeflight) {
		
		return typeFlightDao.getByTypeofSeat(typeflight);
	}

}

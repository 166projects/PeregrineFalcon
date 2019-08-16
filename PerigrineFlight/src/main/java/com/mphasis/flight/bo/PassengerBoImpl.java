package com.mphasis.flight.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.flight.dao.PassengerDao;
import com.mphasis.flight.entities.Passenger;
@Service
public class PassengerBoImpl implements PassengerBo {
	@Autowired
	PassengerDao passengerDao;

	public List<Passenger> getPassengers() {
		
		return passengerDao.getPassengers();
	}

	public List<Passenger> getByName(String name) {
	
		return passengerDao.getByName(name);
	}

	public List<Passenger> getByGender(String gender) {
	
		return passengerDao.getByGender(gender);
	}

	public List<Passenger> getByAge(int age) {
		
		return passengerDao.getByAge(age);
	}

	public void updatePassenger(Passenger passenger) {
		
		passengerDao.updatePassenger(passenger);
	}

	public void addPassenger(Passenger passenger) {
		
		if((passenger.getGender().matches("[fFmM]{1}")) && (passenger.getPhone()>1L))
			
			passengerDao.addPassenger(passenger);
	
	}

	public void deletePassenger(String id) {
		
		passengerDao.deletePassenger(id);
	}

}

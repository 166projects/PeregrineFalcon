package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.Passenger;

public interface PassengerDao {
	

	public List<Passenger> getPassengers();
	public List<Passenger> getByName(String name);
	public List<Passenger> getByGender(String gender);
	public List<Passenger> getByAge(int age);
	public void updatePassenger(Passenger passenger);
	public void addPassenger(Passenger passenger);
	public void deletePassenger(int id);
}

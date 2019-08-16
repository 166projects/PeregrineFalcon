package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.Booking;

public interface BookingDao {
	
	public void addBooking(Booking booking);
	public void deleteBooking(String bid);
	public List<Booking> getAll();
	public Booking getById(String bid);
	public int getTotalFare(String bid);
}

package com.mphasis.flight.dao;

import java.util.List;

import com.mphasis.flight.entities.Booking;

public interface BookingDao {
	
	public void addBooking(Booking booking);
	public void deleteBooking(Booking booking);
	public List<Booking> getAll();
	public Booking getById(int bid);
}

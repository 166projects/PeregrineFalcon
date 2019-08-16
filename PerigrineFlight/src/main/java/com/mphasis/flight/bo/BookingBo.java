package com.mphasis.flight.bo;

import java.time.LocalDate;
import java.util.List;

import com.mphasis.flight.entities.Booking;

public interface BookingBo {
	
	public void addBooking(Booking booking);
	public void deleteBooking(String bid);
	public List<Booking> getAll();
	public Booking getById(String bid);
	public int getTotalFare(String bid);
	
}

package com.mphasis.flight.bo;

import java.time.LocalDate;
import java.util.List;

import com.mphasis.flight.entities.Booking;

public interface BookingBo {
	
	public void addBooking(Booking booking);
	public void deleteBooking(Booking booking);
	public List<Booking> getAll();
	public Booking getById(int bid);
}

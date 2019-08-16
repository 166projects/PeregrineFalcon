package com.mphasis.flight.bo;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mphasis.flight.entities.Booking;
import com.mphasis.flight.exceptions.BusinessException;
import com.mphasis.flight.dao.BookingDao;


@Service
public class BookingBoImpl implements BookingBo{
	
	@Autowired
	BookingDao bookingDao;
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingDao.addBooking(booking);
	}

	public void deleteBooking(String bid) {
		// TODO Auto-generated method stub
		bookingDao.deleteBooking(bid);
	}

	public List<Booking> getAll() {
		// TODO Auto-generated method stub
		List<Booking> booking=bookingDao.getAll();
		if(booking.isEmpty()) {
			try {
			throw new BusinessException("No Booking Details available");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return booking;	
	}

	public Booking getById(String bid) {
		// TODO Auto-generated method stub
		
		return bookingDao.getById(bid);
	}

	@Override
	public int getTotalFare(String bid) {
		// TODO Auto-generated method stub
		return bookingDao.getTotalFare(bid);
	}

}

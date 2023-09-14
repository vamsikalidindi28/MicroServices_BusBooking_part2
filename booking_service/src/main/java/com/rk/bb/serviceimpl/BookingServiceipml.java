package com.rk.bb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.bb.entity.Booking;
import com.rk.bb.repository.bookingRepository;
import com.rk.bb.service.BookingService;
@Service
public class BookingServiceipml implements BookingService {

	@Autowired
	private bookingRepository bookingrepository;

	@Override
	public boolean createBooking(Booking booking) {
		return bookingrepository.save(booking).getBooking_id()>0;
	}

	@Override
	public List<Booking> getAllBookings() {
		return bookingrepository.findAll();
	}

	@Override
	public Booking getBookingById(long id) {
		return bookingrepository.findById(id).get();
	}

	@Override
	public boolean updateBooking(Booking booking) {
		return bookingrepository.save(booking) != null;
	}

	@Override
	public boolean deleteBooking(long id) {
		try {
			bookingrepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
}

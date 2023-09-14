package com.rk.bb.service;

import java.util.List;

import com.rk.bb.entity.Booking;

public interface BookingService {

	boolean createBooking(Booking booking);

	List<Booking> getAllBookings();

	Booking getBookingById(long id);

	boolean updateBooking(Booking booking);

	boolean deleteBooking(long id);
}

package com.rk.bb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.bb.entity.Booking;
import com.rk.bb.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/creatingbooking")
	public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
		boolean isregister = bookingService.createBooking(booking);
		if (isregister) {
			return new ResponseEntity<Booking>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Booking>(HttpStatus.NOT_EXTENDED);
		}
	}

	@GetMapping("/getbooking")
	public ResponseEntity<List<Booking>> getAllBookings() {
		return new ResponseEntity<List<Booking>>(bookingService.getAllBookings(), HttpStatus.FOUND);
	}

	@GetMapping("/getBookingById/{id}")
	public ResponseEntity<Booking> getBusById(@PathVariable("id") long id) {
		Booking booking = bookingService.getBookingById(id);
		return new ResponseEntity<Booking>(booking, HttpStatus.FOUND);

	}

	@PutMapping("/updateBooking")
	public ResponseEntity<Booking> updateBus(@RequestBody Booking booking) {
		boolean isupdated = bookingService.updateBooking(booking);
		if (isupdated) {
			return new ResponseEntity<Booking>(booking, HttpStatus.OK);
		} else {
			return new ResponseEntity<Booking>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<Void>deleteBooking(@PathVariable ("id") long id){
		bookingService.deleteBooking(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

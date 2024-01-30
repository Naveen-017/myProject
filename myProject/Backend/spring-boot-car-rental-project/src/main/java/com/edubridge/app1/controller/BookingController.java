package com.edubridge.app1.controller;

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

import com.edubridge.app1.model.Booking;

import com.edubridge.app1.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

	@Autowired
	private BookingService service;

	/*
	 * http://localhost:8181/myapp/api/Booking
	 */
	// save booking
	@PostMapping("/booking")
	public ResponseEntity<Booking> save(@RequestBody Booking booking) {
		Booking savedBooking = service.saveBooking(booking);
		return new ResponseEntity<>(savedBooking, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/booking
	 */

	// < get all bookings
	@GetMapping("/booking")
	public ResponseEntity<?> getAllBookings() {
		List<Booking> bookings = service.getBookings();
		System.out.println(bookings);
		return new ResponseEntity<>(bookings, HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/booking/1
	 */

	// get one booking
	@GetMapping("/booking/{id}")
	public ResponseEntity<Booking> getOneUser(@PathVariable("id") Integer BookingId) {
		Booking booking = service.getBooking(BookingId);
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

	// delete one booking
	@DeleteMapping("/booing/{id}")
	public ResponseEntity<Booking> deleteUser(@PathVariable("id") Integer BookingId) {
		service.deleteBooking(BookingId);
		return new ResponseEntity<Booking>(HttpStatus.OK);
	}

	/*
	 * http://localhost:8181/myapp/api/booking/1
	 */
	@PutMapping("/booking")
	public ResponseEntity<Booking> update(@RequestBody Booking booking) {
		service.updateBooking(booking);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

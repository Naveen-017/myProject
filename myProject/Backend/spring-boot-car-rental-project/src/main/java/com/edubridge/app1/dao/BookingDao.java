package com.edubridge.app1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.edubridge.app1.model.Booking;

import com.edubridge.app1.repo.BookingRepository;

@Repository
public class BookingDao {
	
	@Autowired
	private BookingRepository repo;

	public Booking saveBooking(Booking e) {
		return repo.save(e);
	}

	public List<Booking> getBookings() {
		return repo.findAll();
	}

	public Booking getBooking(Integer BookingId) {
		return repo.findById(BookingId).get();
	}

	public void updateBooking(Booking e) {
		repo.save(e);
	}

	public void deleteBooking(Integer BookingId) {
		repo.deleteById(BookingId);
	}

}

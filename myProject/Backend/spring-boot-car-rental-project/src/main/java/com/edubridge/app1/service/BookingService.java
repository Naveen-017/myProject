package com.edubridge.app1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.BookingDao;

import com.edubridge.app1.model.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDao dao;

	public Booking saveBooking(Booking e) {
		return dao.saveBooking(e);
	}

	public List<Booking> getBookings() {
		return dao.getBookings();
	}

	public Booking getBooking(Integer BookingId) {
		return dao.getBooking(BookingId);
	}

	public void updateBooking(Booking e) {
		dao.updateBooking(e);

	}

	public void deleteBooking(Integer BookingId) {
		dao.deleteBooking(BookingId);
	}

}

package com.eventsports.service;

import com.eventsports.dao.BookingDao;
import com.eventsports.entity.Booking;
import com.eventsports.entity.Event;
import com.eventsports.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.save(booking);
	}

	@Override
	public Booking updateBooking(Booking booking) {
		// TODO Auto-generated method stub
		return bookingDao.save(booking);
	}

	@Override
	public Booking getBookingById(int bookingId) {

		Optional<Booking> optional = this.bookingDao.findById(bookingId);

		if (optional.isEmpty()) {
			return null;
		}

		return optional.get();
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return this.bookingDao.findAll();
	}

	@Override
	public List<Booking> getBookingByEvent(Event event) {
		// TODO Auto-generated method stub
		return this.bookingDao.findByEvent(event);
	}

	@Override
	public List<Booking> getBookingByCustomer(User customer) {
		// TODO Auto-generated method stub
		return this.bookingDao.findByCustomer(customer);
	}

	@Override
	public List<Booking> getBookingsByBookingId(String bookingId) {
		// TODO Auto-generated method stub
		return this.bookingDao.findByBookingIdContainingIgnoreCase(bookingId);
	}

}

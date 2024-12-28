package com.eventsports.service;

import com.eventsports.entity.Booking;
import com.eventsports.entity.Event;
import com.eventsports.entity.User;

import java.util.List;

public interface BookingService {

	Booking addBooking(Booking booking);

	Booking updateBooking(Booking booking);

	Booking getBookingById(int bookingId);

	List<Booking> getAllBookings();

	List<Booking> getBookingByEvent(Event event);

	List<Booking> getBookingByCustomer(User customer);

	List<Booking> getBookingsByBookingId(String bookingId);

}

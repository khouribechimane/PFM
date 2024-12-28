package com.eventsports.dao;

import com.eventsports.entity.Booking;
import com.eventsports.entity.Event;
import com.eventsports.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDao extends JpaRepository<Booking, Integer> {

	List<Booking> findByCustomer(User customer);

	List<Booking> findByEvent(Event event);

	List<Booking> findByBookingIdContainingIgnoreCase(String bookingId);

}

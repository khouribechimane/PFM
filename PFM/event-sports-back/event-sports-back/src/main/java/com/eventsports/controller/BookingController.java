package com.eventsports.controller;

import com.eventsports.dto.BookingRequestDto;
import com.eventsports.dto.BookingResponseDto;
import com.eventsports.dto.CommonApiResponse;
import com.eventsports.resource.BookingResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

	@Autowired
	private BookingResource bookingResource;

	@PostMapping("add")
	public ResponseEntity<CommonApiResponse> addEvent(@RequestBody BookingRequestDto request) {
		return this.bookingResource.addBooking(request);
	}

	@GetMapping("fetch/all")
	public ResponseEntity<BookingResponseDto> fetchAllBookings() {
		return this.bookingResource.fetchAllBookings();
	}

	@GetMapping("fetch/event-wise")
	public ResponseEntity<BookingResponseDto> fetchAllBookingsByEvent(@RequestParam("eventId") Integer eventId) {
		return this.bookingResource.fetchAllBookingsByEvent(eventId);
	}

	@GetMapping("fetch/customer-wise")
	public ResponseEntity<BookingResponseDto> fetchAllBookingsByCustomer(
			@RequestParam("customerId") Integer customerId) {
		return this.bookingResource.fetchAllBookingsByCustomer(customerId);
	}

}

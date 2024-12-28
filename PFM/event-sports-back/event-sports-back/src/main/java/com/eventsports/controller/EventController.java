package com.eventsports.controller;

import com.eventsports.dto.AddEventRequestDto;
import com.eventsports.dto.CommonApiResponse;
import com.eventsports.dto.EventResponseDto;
import com.eventsports.resource.EventResource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/event")
@CrossOrigin(origins = "http://localhost:3000")
public class EventController {

	@Autowired
	private EventResource eventResource;

	@PostMapping("add")
	public ResponseEntity<CommonApiResponse> addEvent(AddEventRequestDto request) {
		return this.eventResource.addEvent(request);
	}

	@PutMapping("update")
	public ResponseEntity<CommonApiResponse> updateEvent(AddEventRequestDto request) {
		return this.eventResource.updateEvent(request);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<CommonApiResponse> deleteEvent(@RequestParam("eventId") Integer eventId) {
		return this.eventResource.deleteEvent(eventId);
	}

	@GetMapping("fetch/all/active")
	public ResponseEntity<EventResponseDto> fetchActiveEvents() {
		return this.eventResource.fetchActiveEvents();
	}

	// for admin side
	@GetMapping("fetch/all")
	public ResponseEntity<EventResponseDto> fetchAllEvents(@RequestParam("status") String status) {
		return this.eventResource.fetchAllEventsByStatus(status);
	}

	@GetMapping("fetch/category-wise")
	public ResponseEntity<EventResponseDto> fetchActiveEventsByCategory(
			@RequestParam("categoryId") Integer categoryId) {
		return this.eventResource.fetchActiveEventsByCategory(categoryId);
	}

	@GetMapping("fetch/name-wise")
	public ResponseEntity<EventResponseDto> searchActiveEventsByName(@RequestParam("eventName") String eventName) {
		return this.eventResource.searchActiveEventsByName(eventName);
	}
	
	@GetMapping("fetch")
	public ResponseEntity<EventResponseDto> fetchEventByEventId(@RequestParam("eventId") Integer eventId) {
		return this.eventResource.fetchEventByEventId(eventId);
	}
	
	@GetMapping(value = "/{eventImageName}", produces = "image/*")
	public void fetchProductImage(@PathVariable("eventImageName") String productImageName, HttpServletResponse resp) {
		this.eventResource.fetchEventImage(productImageName, resp);
	}

}

package com.eventsports.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String bookingId;

	private String bookingTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_id")
	private Event event;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private User customer;
	
	private String status; // confirmed, cancelled
	
	private BigDecimal amount;
	
	private int noOfTickets;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private Payment payment;

}

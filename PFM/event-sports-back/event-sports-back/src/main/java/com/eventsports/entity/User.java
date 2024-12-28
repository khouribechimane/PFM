package com.eventsports.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String lastName;

	private String emailId;

	@JsonIgnore
	private String password;

	private String phoneNo;

	private String role;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	private String status;

}

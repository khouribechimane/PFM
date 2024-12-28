package com.eventsports.dto;

import com.eventsports.entity.Address;
import com.eventsports.entity.User;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Data
public class UserDto {
	
	private int id;

	private String firstName;

	private String lastName;

	private String emailId;

	private String phoneNo;

	private String role;

	private Address address;

	private UserDto seller;

	private String status;
	
	private BigDecimal walletAmount;
	
	public static UserDto toUserDtoEntity(User user) {
		UserDto userDto =new UserDto();
		BeanUtils.copyProperties(user, userDto, "seller");		
		return userDto;
	}

}

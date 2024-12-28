package com.eventsports.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserResponseDto extends CommonApiResponse {
	
	private List<UserDto> users = new ArrayList<>();

}

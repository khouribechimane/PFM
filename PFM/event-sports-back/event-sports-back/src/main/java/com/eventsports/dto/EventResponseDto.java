package com.eventsports.dto;

import com.eventsports.entity.Event;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EventResponseDto extends CommonApiResponse {

	private List<Event> events = new ArrayList();

}

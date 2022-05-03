package com.endavel.eventsdava.services;

import java.util.List;
import java.util.UUID;

import com.endavel.eventsdava.domain.Event;
import com.endavel.eventsdava.services.exceptions.EventNotFoundException;

public interface IEventService {

	List<Event> getAllEvents();

	Event getEventById(UUID id) throws EventNotFoundException;

	Event createEvent(Event event);

	List<Event> getEventsByType(String type);

}

package com.endavel.eventsdava.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endavel.eventsdava.domain.Event;
import com.endavel.eventsdava.persistance.EventsRepository;
import com.endavel.eventsdava.services.exceptions.EventNotFoundException;
import com.endavel.eventsdava.validations.EventsValidations;

@Service
public class EventService implements IEventService {

	private EventsRepository eventsRepository;
	private EventsValidations eventsValidations;
	
	@Autowired
	public void setClientRepository(EventsRepository eventsRepository) {
		this.eventsRepository = eventsRepository;
	}

	@Override
	public List<Event> getAllEvents() {
		return (List<Event>) eventsRepository.findAll();
	}
	
	@Override
	public Event getEventById(UUID id) throws EventNotFoundException {		
		return eventsRepository.findById(id).orElseThrow(EventNotFoundException::new);
	}

	@Override
	public Event createEvent(Event event) {
		if (eventsValidations.isValidName(event.getName()) 
				&& eventsValidations.isValidType(event.getType()) 
				&& eventsValidations.isValidLocation(event.getLocation())
				&& eventsValidations.isValidDescription(event.getDescription()) ) {
			Event newEvent = new Event(event);
			return eventsRepository.save(newEvent);
		}
		throw new EventNotFoundException();
	}

	@Override
	public List<Event> getEventsByType(String type) {
		List<Event> eventsFilterByType = new ArrayList<>();
		for (Event event : getAllEvents()) {
			if (event.getType().equals(type)) {
				eventsFilterByType.add(event);
			}
		}
		return eventsFilterByType;
	}
	
}

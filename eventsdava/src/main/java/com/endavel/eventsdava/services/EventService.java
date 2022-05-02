package com.endavel.eventsdava.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.endavel.eventsdava.domain.Event;
import com.endavel.eventsdava.persistance.EventsRepository;
import com.endavel.eventsdava.services.exceptions.EventNotFoundException;

@Service
public class EventService implements IEventService {

	private EventsRepository eventsRepository;
	
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
	
}

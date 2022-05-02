package com.endavel.eventsdava.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.endavel.eventsdava.domain.Event;
import com.endavel.eventsdava.services.IEventService;

@RestController
@RequestMapping("/api/v1.0/events") 
public class EventsController {
	private IEventService eventService;
	
	public EventsController(IEventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping
    public ResponseEntity<List<Event>> getAllEvents(@RequestParam(required = false) String type){
		if (type != null) {
			return ResponseEntity.ok(eventService.getEventsByType(type));
		}
		return ResponseEntity.ok(eventService.getAllEvents());
    }
	
	@PostMapping
    public ResponseEntity<Event> postEvent(@RequestBody Event event){
		return ResponseEntity.ok(eventService.createEvent(event));
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable UUID id){
		return ResponseEntity.ok(eventService.getEventById(id));
    }

}

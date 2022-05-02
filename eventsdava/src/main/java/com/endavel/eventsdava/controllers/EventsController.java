package com.endavel.eventsdava.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.endavel.eventsdava.domain.Event;
import com.endavel.eventsdava.services.IEventService;

@RestController
@RequestMapping("/api/eventsdava") 
public class EventsController {
	
	@GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
		return ResponseEntity.ok(IEventService.getAllEvents());
    }
//	@GetMapping
//    public ResponseEntity<List<Event>> getEventByType(){
//		return ResponseEntity.ok(IEventService.getAllEvents());
//    }
	@GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id){
		return ResponseEntity.ok(IEventService.getEventById());
    }
	
	
}
package com.endavel.eventsdava.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Event {

	@Id
	@Type(type = "uuid-char")
	private UUID idEvent = UUID.randomUUID();
	
	private String name;
	private String type;
	private LocalDate date;
	private LocalTime time;
	private Integer price;
	private String location;
	private String description;
	
	public Event() {}
	
	public Event(Event event) {
		this.idEvent = event.getIdEvent();
		this.name = event.getName();
		this.type = event.getType();
		this.date = event.getDate();
		this.time = event.getTime();
		this.price = event.getPrice();
		this.location = event.getLocation();
		this.description = event.getDescription();
	}

	public UUID getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(UUID idEvent) {
		this.idEvent = idEvent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}

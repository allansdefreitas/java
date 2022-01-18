package br.edu.allan.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.allan.model.Event;


@Named
@SessionScoped
public class EventBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	Event event; // Dependency injection
	private List<Event> events = new ArrayList<Event>();

	public void addEvent() {
		//add event to the list
		this.events.add(event);
		clean();
		System.out.println("Event " + event + " added successfully");
		
	}
	
	public void clean() {
		this.event = new Event();
	}
	
	//Getters and Setters
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
}

package com.manifesto.event;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/event")
public class EventController {

	@Autowired
	private EventService service;


	@GetMapping(path="/test")
	public @ResponseBody String test() {
		return "asdf";
	}


	@GetMapping(path="/all")
	public @ResponseBody List<Event> getAllEvents() {
		return service.getAllEvents();
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Event getEvent(@PathVariable int id) {
		return service.getEvent(id);
	}
	
	@GetMapping(path="/name/{name}")
	public @ResponseBody Event get(@PathVariable String name) {
		return service.getEvent(name);
	}
	
	@GetMapping(path="userId/{id}")
	public @ResponseBody List<Event> getAllEventsOfUser(@PathVariable int id) {
		return service.getAllEventsOfUser(id);
	}

	@GetMapping(path="/getName/{id}")
	public @ResponseBody String getEventName(@PathVariable int id) {
		return service.getEventName(id);
	}
	
	@PostMapping(path="/add")
	public void addEvent(@RequestBody Event event) {
		service.createEvent(event);
	}
	
	@PutMapping(path="/{id}")
	public void updateEvent(@RequestBody Event event, @PathVariable int id) {
		service.updateEevnt(event);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteEvent(@PathVariable int id) {
		service.deleteEvent(id);
	}
	
}

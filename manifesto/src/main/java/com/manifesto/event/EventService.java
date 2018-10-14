package com.manifesto.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;
	
	
	public List<Event> getAllEvents() {
		List<Event> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

	public void createEvent(Event event) {
		repository.save(event);
	}

	public void deleteEvent(int id) {
		repository.deleteById(id);
	}

	public void updateEevnt(Event event) {
		repository.save(event);
	}

	public Event getEvent(int id) {
		return repository.findById(id).get();
	}

	public Event getEvent(String name) {
		return repository.findByName(name);
	}
	
	public List<Event> getAllEventsOfUser(int userId) {
		return repository.getAllEventsOfUses(userId);
	}

	public String getEventName(int id) {
		Object o = repository.getEventName(id);
		return "\"" + o.toString() + "\"";
	}
	
}

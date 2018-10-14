package com.manifesto.event;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {

	public Event findByName(String name);
	
	@Query(value = "SELECT * FROM event e,following f WHERE e.id = f.event_id AND f.user_id = ?1", nativeQuery = true)
	public List<Event> getAllEventsOfUses(int userId);
	
	@Query(value = "SELECT e.name FROM event e WHERE e.id = ?1", nativeQuery = true)
	public Object getEventName(int id);

}

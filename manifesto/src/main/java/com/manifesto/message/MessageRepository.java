package com.manifesto.message;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {

	@Query(value = "SELECT * FROM message m "
			+ "WHERE m.sender_id IN (?1, ?2) AND m.receiver_id IN (?1, ?2) "
			+ "ORDER BY time ASC", nativeQuery = true)
	List<Message> getChat(int interlocutor_one, int interlocutor_two);

}

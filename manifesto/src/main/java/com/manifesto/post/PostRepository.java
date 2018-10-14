package com.manifesto.post;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer>{

	public List<Post> findAllByUserId(int id);
	
	public List<Post> findAllByEventId(int id);

	@Query(value = "SELECT * FROM post p WHERE p.event_id IN ?1", nativeQuery = true)
	public List<Post> getPostsOfEvents(List<Integer> eventIds);
	
	@Query(value = "select p.* from post p, event e, following f where p.event_id = e.id and e.id = f.event_id and f.user_id = ?1 order by p.time desc;", nativeQuery = true)
	public List<Post> getAllRelevantPostForUser(int id);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE post p SET p.image = ?2 WHERE p.id = ?1", nativeQuery = true)
	public int setImageUrl(int id, String imageUrl);
	
	
}

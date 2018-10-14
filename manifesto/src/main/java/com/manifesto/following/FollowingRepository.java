package com.manifesto.following;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FollowingRepository extends CrudRepository<Following, Integer> {

	public List<Following> findAllByUserIdAndEventId(int userId, int eventId);
	
	public List<Following> findAllByUserId(int userId);
	
	public List<Following> findAllByEventId(int eventId);
	
	@Modifying
    @Transactional
    @Query(value = "delete from following where following.user_id=?1 and following.event_id=?2", nativeQuery = true)
	public void deleteByUserIdAndEventId(int userId, int eventId);
}

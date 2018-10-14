package com.manifesto.following;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FollowingService {

	@Autowired
	private FollowingRepository repository;
	
	public List<Following> getFollowingsByUserId(int id) {
		List<Following> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

	public void addNewFollowing(Following following) {
		repository.save(following);
	}

	public List<Integer> getEventsFollowedByUser(int id) {
		List<Integer> list = new ArrayList<>();
		repository.findAllByUserId(id).forEach(x -> list.add(x.getEventId()));
		return list;
	}
	
	public List<Integer> getUsersFollowingEvent(int id) {
		List<Integer> list = new ArrayList<>();
		repository.findAllByEventId(id).forEach(x -> list.add(x.getUserId()));
		return list;
	}

	public void removeFollowing(Following following) {
		repository.deleteByUserIdAndEventId(following.getUserId(), following.getEventId());
	}

}

package com.manifesto.following;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manifesto.utils.ResponseMessage;

@Controller
@RequestMapping(path="/following")
public class FollowingController {

	@Autowired
	private FollowingService service;
	
	@GetMapping(path="/user/{id}")
	public @ResponseBody List<Following> getFollowingsByUserId(@PathVariable int id) {
		return service.getFollowingsByUserId(id);
	}
	
	@GetMapping(path="/eventsOfUser/{id}")
	public @ResponseBody List<Integer> getEventsFollowedByUser(@PathVariable int id) {
		return service.getEventsFollowedByUser(id);
	}
	
	@GetMapping(path="/followersOfEvent/{id}")
	public @ResponseBody List<Integer> getUsersFollowingEvent(@PathVariable int id) {
		return service.getUsersFollowingEvent(id);
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ResponseMessage<Following> addNewFollowing(@RequestBody Following following) {
		service.addNewFollowing(following);
		return new ResponseMessage<Following> (true, "Foollowing added");
	}
//	
//	@DeleteMapping(path="/remove/{id}")
//	public void removeFollowing(@PathVariable int id) {
//		service.removeFollowing(id);
//	}
	
	@PostMapping(path="/remove")
	public @ResponseBody ResponseMessage<Following> removeFollowing(@RequestBody Following following) {
		service.removeFollowing(following);
		return new ResponseMessage<Following> (true, "Foollowing removed");
	}
	
	
	
}

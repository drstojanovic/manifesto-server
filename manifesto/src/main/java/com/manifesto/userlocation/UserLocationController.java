package com.manifesto.userlocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/userLocation")
public class UserLocationController {

	@Autowired
	private UserLocationService service;
	
	@GetMapping(path="/test")
	public @ResponseBody String test() {
		return "testing";
	}
	
	@PutMapping(path = "/update")
	public void updateLocation(@RequestBody UserLocation userLocation) {
		service.updatelocation(userLocation);
	}
	
	@GetMapping(path = "/get/{userId}")
	public @ResponseBody UserLocation getLocation(@PathVariable int userId) {
		return service.getLocation(userId);
	}
	
	
}

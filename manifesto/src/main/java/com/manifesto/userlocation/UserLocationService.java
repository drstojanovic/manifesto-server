package com.manifesto.userlocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLocationService {

	@Autowired
	private UserLocationRepository repository;

	public void updatelocation(UserLocation userLocation) {
		repository.save(userLocation);
	}

	public UserLocation getLocation(int id) {
		return repository.findById(id);
	}
	
}

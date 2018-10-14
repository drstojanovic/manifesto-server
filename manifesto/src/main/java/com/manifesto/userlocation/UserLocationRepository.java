package com.manifesto.userlocation;

import org.springframework.data.repository.CrudRepository;

public interface UserLocationRepository extends CrudRepository<UserLocation, Integer> {

	public UserLocation findById(int id);
	
}

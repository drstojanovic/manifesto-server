package com.manifesto.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmail(String email);
	
	@Query (value = "SELECT * FROM user u WHERE u.email = ?1 AND BINARY u.password = ?2", nativeQuery = true)
	public User findByEmailAndPassword(String email, String password);
	
	public User findById(int id);
}

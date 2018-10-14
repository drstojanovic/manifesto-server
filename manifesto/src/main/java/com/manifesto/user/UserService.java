package com.manifesto.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manifesto.utils.ResponseMessage;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public ResponseMessage<User> addUser(User user) {
		if (repository.findByEmail(user.getEmail()) != null)
			return new ResponseMessage<User>(false, "User with specified email allready exists!");

		if (repository.save(user) != null)
			return new ResponseMessage<>(true, "User registred succesfully");
		
		return ResponseMessage.error();
	}

	public ResponseMessage<User> login(User u) {
		User user = repository.findByEmailAndPassword(u.getEmail(), u.getPassword());
		return user != null ? new ResponseMessage<>(true, "", user) : new ResponseMessage<>(false, "Wrong credentials");
	}

	public ResponseMessage<User> updateUser(User u) {
		User user = repository.save(u);
		return user != null ? new ResponseMessage<>(true, "User data updated", user) : new ResponseMessage<>(false, "Error happend during saving data.");
	}

	public User getUser(int id) {
		return repository.findById(id);
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		repository.findAll().forEach(x -> users.add(x));
		return users;
	}

}

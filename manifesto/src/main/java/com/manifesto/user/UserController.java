package com.manifesto.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manifesto.utils.ResponseMessage;

@Controller
@RequestMapping(path="/user")
public class UserController {

	@Autowired
	private UserService service;
	
	
	@PostMapping(path="/login")
	public @ResponseBody ResponseMessage<User> login(@RequestBody User user) {
		return service.login(user);
	}
	
	@PostMapping(path="/signup")
	public @ResponseBody  ResponseMessage<User> signUp(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@PutMapping(path="/update")
	public @ResponseBody ResponseMessage<User> updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		return service.getUser(id);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
}







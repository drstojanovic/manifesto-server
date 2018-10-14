package com.manifesto.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manifesto.utils.ResponseMessage;


@Controller
@RequestMapping(path="/post")
public class PostController {

	@Autowired
	private PostService service;
	

	@GetMapping(path="/all")
	public @ResponseBody List<Post> getAllPosts() {
		return service.getAllPosts();
	}
	
	@GetMapping(path="/relevantForUser/{id}")
	public @ResponseBody List<Post> getAllRelevantPostForUser(@PathVariable int id) {
		return service.getAllRelevantPostForUser(id);
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Post getPost(@PathVariable int id) {
		return service.getPost(id);
	}
	
	@GetMapping(path="/user/{id}")
	public @ResponseBody List<Post> getPostsByUserId(@PathVariable int id) {
		return service.getPostsByUserId(id);
	}
	
	@GetMapping(path="/event/{id}")
	public @ResponseBody List<Post> getPostsByEventId(@PathVariable int id) {
		return service.getPostsByEventId(id);
	}
	
	@PostMapping(path="/forEvents")
	public @ResponseBody List<Post> getPostsOfEvents(@RequestBody List<Integer> eventsIds) {
		return service.getPostsOfEvents(eventsIds);
	}
	
	@PostMapping(path="/add")
	public @ResponseBody ResponseMessage<Post> addPost(@RequestBody Post post) {
		return service.createPost(post);
	}
	
	@PutMapping(path="/{id}")
	public @ResponseBody ResponseMessage<Post> updatePost(@RequestBody Post post, @PathVariable int id) {
		return service.updatePost(post);
	}
	
	@PutMapping(path="/setImageUrl/{id}")
	public @ResponseBody ResponseMessage<Post> setImageUrl(@PathVariable int id, @RequestBody String imageUrl) {
		return service.setImageUrl(id, imageUrl);
	}

	@DeleteMapping(path="/{id}")
	public void deletePost(@PathVariable int id) {
		service.deletePost(id);
	}
}

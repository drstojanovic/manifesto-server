package com.manifesto.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.manifesto.amqp.MessagingService;
import com.manifesto.amqp.PostNotificationMessage;
import com.manifesto.utils.ResponseMessage;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> getAllPosts() {
		List<Post> list = new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

	public Post getPost(int id) {
		return repository.findById(id).get();
	}

	public ResponseMessage<Post> createPost(Post post) {
		ResponseMessage<Post> response;
		Post p = repository.save(post);
		if (p == null) {
			response = new ResponseMessage<>(false, "Some error happend. Post not created.");
		} else {
			response = new ResponseMessage<>(true, "Post created successfully.", p);
			PostNotificationMessage message = new PostNotificationMessage(p.getId(), p.getUser().getId(),
					p.getEventId(), p.getLatitude(), p.getLongitude(), "New post created on your topic of interest",
					p.getType());
			Gson gson = new Gson();
			String msg = gson.toJson(message);
			MessagingService.getInstance().publishNotification(msg, p.getEventName() + "." + p.getType());
		}
		return response;
	}

	public ResponseMessage<Post> updatePost(Post post) {
		Post p = repository.save(post);
		return p == null ? new ResponseMessage<Post>(false, "Post not updated")
				: new ResponseMessage<Post>(true, "Post updated sucessfully", p);
	}

	public void deletePost(int id) {
		repository.deleteById(id);

	}

	public List<Post> getPostsByUserId(int id) {
		return repository.findAllByUserId(id);
	}

	public List<Post> getPostsByEventId(int id) {
		return repository.findAllByEventId(id);
	}

	public List<Post> getPostsOfEvents(List<Integer> eventsIds) {
		return repository.getPostsOfEvents(eventsIds);
	}

	public ResponseMessage<Post> setImageUrl(int id, String imageUrl) {
		repository.setImageUrl(id, imageUrl);
		return new ResponseMessage<Post>(true, "Image updated");
	}

	public List<Post> getAllRelevantPostForUser(int id) {
		return repository.getAllRelevantPostForUser(id);
	}

}

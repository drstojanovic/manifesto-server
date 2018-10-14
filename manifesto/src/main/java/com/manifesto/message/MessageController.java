package com.manifesto.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "message")
public class MessageController {

	@Autowired
	private MessageService service;
	
	@PostMapping(path = "/add")
	public @ResponseBody Boolean addMessage(@RequestBody Message message) {
		return service.addMessage(message);
	}
	
	@GetMapping(path = "/{id}")
	public @ResponseBody Message getMessage(@PathVariable int id) {
		return service.getMessage(id);
	}
	
	@GetMapping(path = "/all/interlocutorOne/{oid}/interlocutorTwo/{tid}")
	public @ResponseBody List<Message> getChat(@PathVariable int oid, @PathVariable int tid) {
		return service.getChat(oid, tid);
	}
	
	
}

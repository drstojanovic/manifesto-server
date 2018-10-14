package com.manifesto.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.manifesto.amqp.MessagingService;

@Service
public class MessageService {

	@Autowired
	private MessageRepository repository;

	public Boolean addMessage(Message message) {
		repository.save(message);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
		String msg = gson.toJson(message);
		MessagingService.getInstance().sendMessage(msg, "messages_queue_user_" + message.getReceiverId());
		return true;
	}

	public Message getMessage(int id) {
		return repository.findById(id).get();
	}

	public List<Message> getChat(int sid, int rid) {
		return repository.getChat(sid, rid);
	}

}

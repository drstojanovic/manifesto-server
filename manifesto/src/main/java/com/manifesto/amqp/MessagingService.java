package com.manifesto.amqp;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.manifesto.utils.Constants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MessagingService {

	private static MessagingService instance;

	private ConnectionFactory factory = new ConnectionFactory();
	private Connection connection;
	private Channel channel;

	private MessagingService() {
		try {
			factory.setHost("localhost");
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare(Constants.EXCHANGE_NAME_POST_NOTIFICATIONS, Constants.EXCHANGE_TYPE_TOPIC);
			channel.exchangeDeclare(Constants.EXCHANGE_NAME_MESSAGING, Constants.EXCHANGE_TYPE_DIRECT);
			System.out.println("AMQP: Initialization completed.");
		} catch (IOException | TimeoutException e) {
			e.printStackTrace();
		}
	}

	public static MessagingService getInstance() {
		if (instance == null) {
			instance = new MessagingService();
		}
		return instance;
	}

	public void sendMessage(String message, String routingKey) {
		try {
			channel.basicPublish(Constants.EXCHANGE_NAME_MESSAGING, routingKey, null, message.getBytes());
			System.out.println("AMQP: Message sent.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void publishNotification(String text, String routingKey) {
		try {
			channel.basicPublish(Constants.EXCHANGE_NAME_POST_NOTIFICATIONS, routingKey, null, text.getBytes());
			System.out.println("AMQP: Notification published.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void destroyService() {
		try {
			channel.close();
			connection.close();
			instance = null;
			System.out.println("AMQP: Shut down.");
		} catch (TimeoutException | IOException e) {
			e.printStackTrace();
		}
	}

}

package com.luoding.mq.rabbitmq.work;

import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Send {
	
	public static final String QUEUE_NAME = "pb-work"; //队列名字
	public static final String host = StaticElement.HOST;
	public static final String 	EXCHANGE_NAME = StaticElement.EXCHANGE_NAME;
	public static final int port = StaticElement.PORT;
	public static void main(String [] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		
		String message = "hello world, my name is luo ding "+(new Date()).getTime();
		channel.basicPublish("", QUEUE_NAME,  MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
		System.out.println("sent message "+message);
		
		
		channel.close();
		connection.close();
	}

}

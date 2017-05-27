package com.luoding.mq.rabbitmq.first;

import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Send {
	
	public static final String QUEUE_NAME = StaticElement.QUEUE_NAME; //
	public static final String host = StaticElement.HOST;
	public static final int port = StaticElement.PORT;
	public static void main(String [] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, true, null);
		for(int i=0;i<15;i++){
			String message = "hello world, my name is luo ding "+(new Date()).getTime();
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println("sent message "+message);
		}
		
		channel.close();
		connection.close();
	}

}

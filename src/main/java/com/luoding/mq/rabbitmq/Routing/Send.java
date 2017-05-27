package com.luoding.mq.rabbitmq.Routing;

import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Send {
	
	public static final String QUEUE_NAME = "routing"; //队列名字
	public static final String host = StaticElement.HOST;
	public static final String 	EXCHANGE_NAME = "routing-exchange";
	public static final int port = StaticElement.PORT;
	public static void main(String [] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
		channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"direct");
		//String message = "wrong -  hello world, my name is luo ding "+(new Date()).getTime();
		String message = "wran -  hello world, my name is luo ding "+(new Date()).getTime();
		channel.basicPublish(EXCHANGE_NAME, "direct", null, message.getBytes());
		System.out.println("sent message "+message);
		
		channel.close();
		connection.close();
	}

}

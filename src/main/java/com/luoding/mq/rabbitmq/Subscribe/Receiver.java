package com.luoding.mq.rabbitmq.Subscribe;

import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receiver {

	public static final String QUEUE_NAME = "subscribe"; //队列名字
	public static final String host = StaticElement.HOST;
	public static final String 	EXCHANGE_NAME = "subscribe-exchange";
	public static final int port = StaticElement.PORT;
	
	public static void main(String [] args) throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		/*channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
		String queueName = channel.queueDeclare().getQueue();
		channel.queueBind(queueName, EXCHANGE_NAME, "");*/
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, true,consumer);
		
		while(true){
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			System.out.println("the message is "+message);
		}
	}
	
}

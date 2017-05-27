package com.luoding.mq.rabbitmq.RPC;

import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RPCClient {

	public static final String QUEUE_NAME = "RPC"; //队列名字
	public static final String host = StaticElement.HOST;
	public static final String 	EXCHANGE_NAME = StaticElement.EXCHANGE_NAME;
	public static final int port = StaticElement.PORT;
	
	public static void main(String [] args) throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		
		String reQueueName = channel.queueDeclare().getQueue();
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(reQueueName, true,consumer);
		
		
		String response = null;
	    String corrId = java.util.UUID.randomUUID().toString();
	    BasicProperties pros = new BasicProperties.Builder().correlationId(corrId).replyTo(reQueueName).build();
	    
	    channel.basicPublish("", QUEUE_NAME, pros, "client".getBytes());
	    
	    while(true){
	    	QueueingConsumer.Delivery delivery = consumer.nextDelivery();
	    	if(delivery.getProperties().getCorrelationId().equals(corrId)){
	    		response = new String(delivery.getBody());
	    		System.out.println(response+"------------");
	    	}
	    }
	}
}

package com.luoding.mq.rabbitmq.RPC;

import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RPCServer {

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
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.basicQos(1);
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, consumer);
		System.out.println(" [x] Awaiting RPC requests");
		while(true){
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			BasicProperties pros = delivery.getProperties();
			BasicProperties rePros = new BasicProperties.Builder().correlationId(pros.getCorrelationId()).build();
			String message = new String(delivery.getBody());
			System.out.println(message+"----server");
			
			channel.basicPublish("", pros.getReplyTo(),rePros, "server".getBytes());
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}
}

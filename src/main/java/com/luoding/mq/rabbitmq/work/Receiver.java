package com.luoding.mq.rabbitmq.work;

import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receiver implements Runnable {

	public static final String QUEUE_NAME = "pb-work"; //队列名字
	public static final String host = StaticElement.HOST;
	public static final String 	EXCHANGE_NAME = StaticElement.EXCHANGE_NAME;
	public static final int port = StaticElement.PORT;
	
	public static void main(String [] args) throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		
		channel.basicQos(3); //
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, false,consumer);
		int count = 0;
		while(true){
			System.out.println(count++);
			Thread.sleep(1000);
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			//work(message);
			System.out.println("the message is "+message+" --9");
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}
	
	public static void work(String str){
		System.out.println("-------------   "+str);
		int time = Integer.parseInt(str.substring(str.length()-1, str.length()));
		System.out.println(time);
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void rece() throws IOException, InterruptedException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, true, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		
		channel.basicQos(3); //璁剧疆娑堟伅鐨勬渶澶ф帴鍙楁暟閲�
		
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(QUEUE_NAME, false,consumer);
		int count = 0;
		while(true){
			System.out.println(count++);
			Thread.sleep(1000);
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String message = new String(delivery.getBody());
			//work(message);
			System.out.println("the message is "+message+" --9");
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
            try {
                rece();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

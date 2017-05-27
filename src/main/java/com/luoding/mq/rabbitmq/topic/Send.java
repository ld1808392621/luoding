package com.luoding.mq.rabbitmq.topic;

import com.luoding .pb.common.util.json.JsonUtil;
import com.luoding.mq.rabbitmq.MessageEntity;
import com.luoding.mq.rabbitmq.VerifyRequest;
import com.luoding.mq.rabbitmq.util.StaticElement;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class Send {

    public static final String QUEUE_NAME = "topic"; //队列名字
    public static final String host = StaticElement.HOST;
    public static final String 	EXCHANGE_NAME = "topic-exchange";
    public static final int port = StaticElement.PORT;

	public static void main(String [] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(5672);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();		
		//String message = "wrong -  hello world, my name is luo ding "+(new Date()).getTime();
		String message = "wran -  hello world, my name is luo ding "+(new Date()).getTime();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "#");

		MessageEntity messageEntity = new MessageEntity();
		messageEntity.setHotelId("52407003");
		messageEntity.setYear_month(new Date());
		
		message = JsonUtil.toJson(messageEntity);
		VerifyRequest vRequest = new VerifyRequest();
		vRequest.setToken(new Long("-100000000000531384"));
		vRequest.setCount(0);
		vRequest.setHotelId("52407003");
		vRequest.setPaymentOrderId(100001007);
		
		AMQP.BasicProperties properties = new AMQP.BasicProperties("text/plain",
                null,
                null,
                2,
                0, null, null, null,
                null, null, vRequest.getClass().getName(), null,
                null, null);
		
		channel.basicPublish(EXCHANGE_NAME, "pb-commission-api.pb-commission-api-payment-callback.*", 
				properties, JsonUtil.toJson(vRequest).getBytes());
		System.out.println("sent message "+message);
		
		channel.close();
		connection.close();
	}

}

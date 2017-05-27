package com.luoding.mq.rabbitmq.util;


import com.luoding.mq.rabbitmq.work.Receiver;

public class test {

	public static void main(String [] ags){
		
		for(int i=0;i<800;i++){
			Thread thread = new Thread(new Receiver());
			thread.start();;
		}
		
	}
}

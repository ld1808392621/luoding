package com.luoding.kafka;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * author: ding.luo
 * time: 17-1-22 下午5:53
 */
public class KafkaProducer {

    private static kafka.javaapi.producer.Producer<Integer, String> producer;
    private static String topic = "platform-fraud-jisuan-log";
    private static Properties props = new Properties();

    static {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "192.168.234.5:9092");
        producer = new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(props));
        topic = topic;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = "";
        data = br.readLine();
        while (!"quit".equals(data)) {
            String messageStr = new String("Message_" + data);
            System.out.println("Send:" + messageStr);
            if(!StringUtils.isBlank(data)){
                producer.send(new KeyedMessage<Integer, String>(topic, messageStr));
            }
            data = br.readLine();
        }
    }
}

package com.luoding.redis.RedisClient.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Date：16-7-5
 * Time：下午9:16
 *
 * @author ding.luo@corp.luoding .com
 */
public class ChannelSimpleClient {

    public static void main(String [] args){

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1",8080));
            String data = "hello world";
            ByteBuffer buffer = ByteBuffer.allocate(128);
            buffer.clear();
            buffer.put(data.getBytes());
            buffer.flip();
            while(buffer.hasRemaining()){
                socketChannel.write(buffer);
            }
            buffer.clear();
            socketChannel.read(buffer);
            buffer.flip();
            System.out.println(new String(buffer.array(),0,buffer.limit()));
            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

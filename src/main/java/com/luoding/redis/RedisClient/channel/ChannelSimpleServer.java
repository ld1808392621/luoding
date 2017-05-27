package com.luoding.redis.RedisClient.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Date：16-7-5
 * Time：下午9:16
 *
 * @author ding.luo@corp.luoding .com
 */
public class ChannelSimpleServer {

    public static void main(String [] args){

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8080));
            SocketChannel socketChannel = serverSocketChannel.accept();
            String data = "server";
            ByteBuffer buffer = ByteBuffer.allocate(128);
            buffer.clear();
            socketChannel.read(buffer);
            buffer.flip();
            System.out.println(new String(buffer.array(),0,buffer.limit()));
            buffer.clear();
            buffer.put(data.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            socketChannel.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

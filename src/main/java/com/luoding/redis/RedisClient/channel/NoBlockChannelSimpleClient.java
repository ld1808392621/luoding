package com.luoding.redis.RedisClient.channel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Date：16-7-5
 * Time：下午10:07
 *
 * @author ding.luo@corp.luoding .com
 */
public class NoBlockChannelSimpleClient {

    public static void main(String[] args) {

        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_CONNECT | SelectionKey.OP_WRITE);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int readyChannels = selector.select();
                if (readyChannels == 0) continue;
                Set selectedKeys = selector.selectedKeys();
                Iterator iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    iterator.remove();
                    if (key.isConnectable()) {
                        SocketChannel socketChannel1 = (SocketChannel) key.channel();
                        if (socketChannel1.isConnectionPending()) {
                            socketChannel1.finishConnect();
                        }
                        System.out.println("连接建立....");
                    } else if (key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(128);
                        socketChannel.read(buffer);
                        buffer.flip();
                        System.out.println(new String(buffer.array(), 0, buffer.limit()));

                    }else if(key.isWritable()){
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(128);
                        String data = reader.readLine();
                        buffer.put(data.getBytes());
                        buffer.flip();
                        channel.write(buffer);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.luoding.redis.RedisClient.channel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * Date：16-7-10
 * Time：下午4:09
 *
 * @author ding.luo@corp.luoding .com
 */
public class DataSocketClient {

    public static void main(String [] args){
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress address1 = new InetSocketAddress("127.0.0.1",8081);
        String data = "client";
        try {
            DatagramSocket socket = new DatagramSocket(8081);
            socket.setSoTimeout(3000);
            DatagramPacket sendPacket = new DatagramPacket(data.getBytes(),0,data.length(),address);
            DatagramPacket receivePacket = new DatagramPacket(new byte[1024],1024);
            socket.send(sendPacket);
            socket.receive(receivePacket);
            System.out.println(new String(receivePacket.getData()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

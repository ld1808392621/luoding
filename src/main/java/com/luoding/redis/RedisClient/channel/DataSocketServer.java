package com.luoding.redis.RedisClient.channel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * Date：16-7-10
 * Time：下午4:20
 *
 * @author ding.luo@corp.luoding .com
 */
public class DataSocketServer {

    public static void main(String [] args){

        try {

            DatagramSocket socket = new DatagramSocket(8080);
            InetSocketAddress address = new InetSocketAddress("127.0.0.1",8081);
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
            socket.receive(packet);
            System.out.println(new String(packet.getData()));
            String data = "server";
            DatagramPacket sendPacket = new DatagramPacket(data.getBytes(),0,data.length(),address);
            socket.send(sendPacket);
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

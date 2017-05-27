package com.luoding.redis.RedisClient;

import com.luoding.redis.RedisClient.data.DataReadThread;
import com.luoding.redis.RedisClient.data.DataWriteThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Date：16-6-29
 * Time：下午8:47
 *
 * @author ding.luo@corp.luoding .com
 */
public class DataSimpleServer {

    public static void main(String [] args){

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while(true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                Thread dataReadThread = new Thread (new DataReadThread(inputStream));
                Thread dataWriteThread = new Thread(new DataWriteThread(outputStream));
                dataReadThread.start();
                dataWriteThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

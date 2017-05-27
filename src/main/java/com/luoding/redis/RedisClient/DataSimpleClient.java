package com.luoding.redis.RedisClient;

import com.luoding.redis.RedisClient.data.DataReadThread;
import com.luoding.redis.RedisClient.data.DataWriteThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Date：16-6-29
 * Time：下午8:46
 *
 * @author ding.luo@corp.luoding .com
 */
public class DataSimpleClient {

    public static void main(String [] args){

        try {
            Socket socket = new Socket("127.0.0.1",8080);
            socket.getChannel();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            Thread dataReadThread = new Thread (new DataReadThread(inputStream));
            Thread dataWriteThread = new Thread(new DataWriteThread(outputStream));
            dataReadThread.start();
            dataWriteThread.start();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}

package com.luoding.redis.RedisClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Date：16-6-29
 * Time：下午7:44
 *
 * @author ding.luo@corp.luoding .com
 */
public class SocketServer {

    public static void main (String [] args){

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            while(true){

                byte[] buffer = new byte[1024];
                inputStream.read(buffer);
                String receive = new String(buffer);
                if("bye".equals(receive)){
                    break;
                }
                System.out.println("R: " + receive);
                String send = br.readLine();
                outputStream.write(send.getBytes());
                System.out.println("S: " + send);
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

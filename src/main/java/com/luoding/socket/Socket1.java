package com.luoding.socket;

import com.luoding.redis.RedisClient.SocketServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: ding.luo
 * time: 17-2-22 下午5:08
 */
public class Socket1 {

    public static void main(String [] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9000);
        Socket socket = serverSocket.accept();
        Thread thread = new Thread(new Server(socket));
        thread.start();
    }

    static class Server implements Runnable{

        private Socket socket;

        public Server(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                byte [] bytes = new byte[1024];
                int size = in.read(bytes);
                String str = new String(bytes,0,size);
                System.out.println(str+"---server");
                String outStr = "现在的时间是"+System.currentTimeMillis();
                out.write(outStr.getBytes());
                out.flush();
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

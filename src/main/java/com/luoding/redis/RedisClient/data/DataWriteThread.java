package com.luoding.redis.RedisClient.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Date：16-6-29
 * Time：下午8:38
 *
 * @author ding.luo@corp.luoding .com
 */
public class DataWriteThread implements Runnable {

    private OutputStream outputStream;

    public DataWriteThread(OutputStream outputStream){
        this.outputStream = outputStream;
    }
    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
                String send = br.readLine();
                outputStream.write(send.getBytes());
                if("bye".equals(send)){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        try {
            br.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

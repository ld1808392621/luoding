package com.luoding.redis.RedisClient.data;

import java.io.IOException;
import java.io.InputStream;

/**
 * Date：16-6-29
 * Time：下午8:38
 *
 * @author ding.luo@corp.luoding .com
 */
public class DataReadThread implements Runnable  {

    private InputStream inputStream;

    public DataReadThread(InputStream inputStream){
        this.inputStream = inputStream;
    }

    @Override
    public void run() {

        while(true){
            byte [] buffer = new byte[1024];
            try {
                inputStream.read(buffer);
                String receive = new String(buffer);
                System.out.println("R: "+ receive);
                if("bye".equals(receive)){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

        }
        try {
            this.inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

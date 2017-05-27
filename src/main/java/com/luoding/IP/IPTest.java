package com.luoding.IP;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Date：16-7-15
 * Time：下午5:29
 *
 * @author ding.luo@corp.luoding .com
 */
public class IPTest {

    public static void main(String[] args) throws IOException {

        File file = new File("ip.txt1");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (int i = 1; i < 126; i++) {
            for (int j = 0; j < 256; j++) {
                String ip = i + "." + j + ".135.37";
                String url = "http://api.ip138.com/query/?datatype=jsonp&token=7f42dc2f67cd8a370ccca809befedaed&ip=" + ip;
                try {
                    String retStr = HttpRequestRetryUtil.getRetry(url, 1);
                    JSONObject json = JSON.parseObject(retStr);
                    String data = ip + " " + json.getString("data") + "\n";
                    bw.write(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        bw.flush();
        bw.close();
    }
}

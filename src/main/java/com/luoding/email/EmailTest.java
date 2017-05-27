package com.luoding.email;

import com.luoding .pb.client.http.common.mail.MailRequest;
import com.luoding .pb.common.util.http.HttpClient;
import com.luoding .pb.common.util.http.HttpClientPost;
import com.luoding .pb.common.util.http.HttpClientResponse;

/**
 * Date：16-9-13
 * Time：下午4:15
 *
 * @author ding.luo@corp.luoding .com
 */
public class EmailTest {

    public static void main(String[] args) {

        MailRequest mailRequest = new MailRequest();
        mailRequest.setFrom("pb-monitor-cashback-job@corp.luoding .com");
        mailRequest.setSubject("123");
        mailRequest.setContent("拦截数据");
        mailRequest.setToArr(new String[]{"ding.luo@corp.luoding .com"});


        try {
            HttpClientPost client = HttpClient.post("http://pb-commons.vip.luoding .com:8080/mail/send");
            HttpClientResponse response = client.json(mailRequest).action();
            System.out.println();
        } catch (Exception e) {
        }
    }
}

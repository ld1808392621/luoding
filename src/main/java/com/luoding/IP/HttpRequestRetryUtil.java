package com.luoding.IP;

import com.luoding .pb.common.util.http.HttpClient;
import com.luoding .pb.common.util.http.HttpClientPost;
import com.luoding .pb.common.util.http.HttpClientResponse;
import com.luoding .pb.common.util.log.PlatformLogger;import java.lang.Exception;import java.lang.String;

/**
 * Date：16-2-19
 * Time：下午12:59
 *
 * @author ding.luo
 */
public class HttpRequestRetryUtil {

    /**
     * http post请求重试
     *
     * @param url
     * @param params
     * @param retry
     * @return
     * @throws Exception
     */
    public static String postRetry(String url, String params, int retry) throws Exception {

        HttpClientPost httpclient = HttpClient.post(url);
        httpclient.timeout(1000, 2000);  //设置超时时间
        httpclient.json(params);
        int currentRetry = 0;
        String result = "";
        HttpClientResponse httpClientResponse = null;
        for (; currentRetry < retry; currentRetry++) {
            try {
                httpClientResponse = httpclient.action();
                //如果解密成功则解密工作结束
                break;
            } catch (Exception e) {
                PlatformLogger.error("调用url: " + url + "异常", e);
                continue;
            }
        }
        if (currentRetry >= retry) {
            throw new Exception("调用url: " + url + "重试" + retry + "异常");
        } else {
            result = httpClientResponse.getBody();
        }
        return result;
    }

    /**
     * http get 请求重试
     *
     * @param url
     * @param retry
     * @return
     * @throws Exception
     */
    public static String getRetry(String url, int retry) throws Exception {

        HttpClient httpClient = HttpClient.get(url);
        httpClient.timeout(1000, 2000);
        HttpClientResponse httpClientResponse = null;
        String result = "";
        int currentRetry = 0;
        for (; currentRetry < retry; currentRetry++) {
            try {
                httpClientResponse = httpClient.action();
                break;
            } catch (Exception e) {
                PlatformLogger.error("调用url: " + url + "异常", e);
                continue;
            }
        }

        if (currentRetry >= retry) {
            throw new Exception("调用url: " + url + "重试" + retry + "异常");
        } else {
            result = httpClientResponse.getBody();
        }
        return result;
    }
}

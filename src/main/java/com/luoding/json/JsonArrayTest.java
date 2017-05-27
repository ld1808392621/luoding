package com.luoding.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Date：16-6-13
 * Time：下午5:43
 *
 * @author ding.luo@corp.luoding .com
 */
public class JsonArrayTest {

    public static void main(String [] args){

        String jsonStr = "{\"ebookOperateDatas\":[{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H1\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"},{\"data\":{\"loginIp\":\"222.216.56.13\",\"loginTime\":\"2016-06-12 04:30:41\",\"operateCNName\":\"李燕._EBK_H\",\"operateId\":\"120056\",\"operateIdAttribute\":\"individual\",\"operateIp\":\"222.216.56.13\",\"operateTime\":\"2016-06-12 10:38:58\"},\"operateType\":\"affirm\",\"orderId\":\"374539914\",\"orderProduct\":\"domesticHotel\",\"requestFrom\":\"Ebooking\"}]}";

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        JSONArray jsonArray = jsonObject.getJSONArray("ebookOperateDatas");
        if(jsonArray.get(0).equals(jsonArray.get(1))){
            System.out.println("相同的");
        }

        String str = "[\"306\",\"307\",\"311\"]";
        JSONArray array = JSONObject.parseArray(str);
        List<String> list = new ArrayList<>();
        System.out.println(array.get(0));

        A a = new A();
        a.setA("1");
        a.setB("2");
        a.setC("3");
        String json = JSONObject.toJSONString(a);
        System.out.println(json);

        json = "{\"a\":\"1\",\"b\":\"2\",\"c\":\"3\",\"d\":\"3\"}";
        A a1 =  JSONObject.parseObject(json,A.class);
        System.out.println(a1.getC());

         str = "hello\\nhello\nhello";
        System.out.println(str.split("\\n").length);
    }
}

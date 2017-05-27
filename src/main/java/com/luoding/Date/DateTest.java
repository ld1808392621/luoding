package com.luoding.Date;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: ding.luo@corp.luoding .com
 * time: 16-10-31 下午7:51
 */
public class DateTest {

    public static void main(String [] args){

        Date date = new Date();
        //1484281922000,1484238722000

        date.setTime(1484281922000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date) +"---0---");

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        date1.setTime(1484238722000L);
        System.out.println(format1.format(date1)+"-----1-----");

        String str = "2017-01-14 16:18:42";
        try {
            System.out.println(format.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(format1.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Double d = new Double(System.currentTimeMillis());
        System.out.println(d.longValue());

    }
}

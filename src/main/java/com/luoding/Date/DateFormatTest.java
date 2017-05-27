package com.luoding.Date;

import com.luoding .pb.common.util.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Date：16-6-17
 * Time：下午6:12
 *
 * @author ding.luo@corp.luoding .com
 */
public class DateFormatTest {


    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            /**
             * 1477843200000  2016-10-31 00:00:00
             * 1477756800000  2016-10-30 00:00:00
             */

            Date date = DateUtil.parseDate("2016/12/5 2:11:56", "yyyy-MM-dd HH:mm:ss");
            int a = 1472400079;
            System.out.println(date.getTime());
        } catch (Exception e) {
            System.out.println("出现异常了");
            e.printStackTrace();
        }


       /* long time = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            long startTime = System.currentTimeMillis();
            getDateArray(1000, "2016-06-06");
            System.out.println(System.currentTimeMillis() - startTime);
        }
        System.out.println(System.currentTimeMillis() - time);*/
    }


    public static List<String> getDateArray(int dayLength, String dateStr) {

        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("日期格式错误,正确为:yyyy-MM-dd");
        }
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= dayLength; i++) {
            date = DateUtil.addDay(date, -1);
            list.add(simpleDateFormat.format(date));
        }
        return list;
    }

    public static List<String> getDateArray1(int dayLength, String dateStr) {

        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("日期格式错误,正确为:yyyy-MM-dd");
        }
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= dayLength; i++) {
            date = DateUtil.addDay(date, -1);
            list.add(new SimpleDateFormat("yyyy-MM-dd").format(date));
        }
        return list;
    }

}

package com.luoding.Date;

import com.luoding .pb.common.util.date.DateUtil;

import java.util.Calendar;

/**
 * Date：16-9-6
 * Time：下午2:11
 *
 * @author ding.luo@corp.luoding .com
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar actionTime = Calendar.getInstance();
        actionTime.set(Calendar.HOUR_OF_DAY, 20);
        actionTime.set(Calendar.MINUTE, 0);
        actionTime.set(Calendar.SECOND, 0);
        String actionTime2 = DateUtil.formatDate(actionTime.getTime());

        actionTime.add(Calendar.DAY_OF_MONTH, -1);
        String actionTime1 = DateUtil.formatDate(actionTime.getTime());

        Calendar handleTime = Calendar.getInstance();
        handleTime.set(Calendar.HOUR_OF_DAY, 8);
        handleTime.set(Calendar.MINUTE, 0);
        handleTime.set(Calendar.SECOND, 0);

        String handleTime1 = DateUtil.formatDate(handleTime.getTime());

        handleTime.set(Calendar.HOUR_OF_DAY, 21);
        handleTime.set(Calendar.MINUTE, 0);
        handleTime.set(Calendar.SECOND, 0);
        String handleTime2 = DateUtil.formatDate(handleTime.getTime());

        System.out.println(actionTime1);
        System.out.println(actionTime2);
        System.out.println(handleTime1);
        System.out.println(handleTime2);
    }
}

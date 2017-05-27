package com.luoding;


import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: ding.luo@corp.luoding .com
 * time: 17-1-7 下午10:56
 */
public class NumVoice {

    public static String unit = "拾百千";
    public static List<String> unit1 = new ArrayList<>();
    static {
        unit1.add("万");
        unit1.add("亿");
        unit1.add("万亿");
    }
    public static String maps = "零壹贰叁肆伍陆柒捌玖";

    public static void main(String[] args) {

        String number = "1000541060000005";
        List<String> parts = parts(number);
        System.out.println(parts);

        List<String> part1 = toChiness(parts);
        System.out.println(part1);
        String str = combine(part1);
        System.out.println(str);

    }

    public static String combine(List<String> parts) {

        int size = parts.size();
        String str = "";
        for (int i = 0; i < size; i++) {
            String u = "";
            if (i != 0) {
                u = u + unit1.get(i - 1);
            }
            String part = parts.get(i);
            if(StringUtils.isBlank(part)){
                continue;
            }
            String t = part + u;
            str = t + str;
        }

        str.replaceAll("零零", "零");

        return str;
    }

    public static List<String> parts(String number) {
        List<String> parts = new ArrayList<>();
        int len = number.length();
        while (len > 0) {
            if (len > 4) {
                String subStr = removeZero(number.substring(len - 4, len));
                parts.add(subStr);
                len = len - 4;
                number = number.substring(0, len);
            } else {
                parts.add(number);
                break;
            }
        }

        return parts;
    }

    public static String removeZero(String str) {

        String tmp = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if ('0' == str.charAt(i)) {
                continue;
            } else {
                tmp = str.substring(i, len);
                break;
            }
        }

        return tmp;
    }

    public static List<String> toChiness(List<String> parts) {

        int size = parts.size();
        List<String> chinesses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String part = parts.get(i);
            int len = part.length();
            String tmp = "";
            boolean pos = false;
            for (int j = len - 1; j >= 0; j--) {
                int index = Integer.parseInt("" + part.charAt(j));
                if(index ==0 && !pos){
                    continue;
                }
                pos = true;
                String ch = "" + maps.charAt(index);
                String u = "";
                if (j != len - 1) {
                    u = u + unit.charAt(len - j - 2);
                }
                String t = ch + u;
               //最前面的不需要加零，一组中的最后面的不需要加零，只有不足四个的才需要在前面加零
                if (i != (size - 1) && len != 4&&j == 0) {
                    t = "零"+t;
                }
                tmp = t + tmp;
            }
            chinesses.add(tmp);
        }


        return chinesses;
    }
}

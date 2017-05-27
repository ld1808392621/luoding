package com.luoding.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Date：16-6-6
 * Time：下午11:37
 *
 * @author ding.luo@corp.luoding .com
 */
public class ParseTest {

    public static void main(String [] args){
        File file = new File("result.txt");
        Map<String,String> maps = new HashMap<String,String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while(true){
                String line = br.readLine();
                if(null == line || "".equals(line)){
                    break;
                }
                String [] keyValues = line.split(",");
                for(String str:keyValues){
                    String [] fields = str.split(":");
                    maps.put(fields[0],fields[1]);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        LogicExpressCalculate logicExpressCalculate = new LogicExpressCalculate(maps);
        String expression = "6823&4853&665&7397&7398";
        try {
            System.out.println(logicExpressCalculate.logicExpressionParse(expression));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

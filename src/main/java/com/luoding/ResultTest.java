package com.luoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Date：16-5-24
 * Time：下午1:24
 *
 * @author ding.luo@corp.luoding .com
 */
public class ResultTest {
    public static void main(String [] args){
        File file = new File("result.txt");
        Map<String,Boolean> maps = new HashMap<String,Boolean>();
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
                    maps.put(fields[0],Boolean.parseBoolean(fields[1]));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String parse = "7020&7115&7109&4853&283&284&1563&6847&7231&7232&7233&7234&7247&7352&7353&7354&7355&7356";
        String [] items = parse.split("&");
        for(String item:items){
            if(null == item ||"".equals(item)){
                continue;
            }
            if(!maps.get(item)){
                System.out.println("没有触发1");
                break;
            }
        }

         parse = "7020&4484&7109&4853&283&284&1563&6847&7231&7232&7233&7234&7247&7352&7353&7354&7355&7356";
         items = parse.split("&");
        for(String item:items){
            if(null == item ||"".equals(item)){
                continue;
            }
            try{
                if(!maps.get(item)){
                    System.out.println("没有触发2");
                    break;
                }
            }catch(Exception e){
                System.out.println(item);
            }

        }
    }
}

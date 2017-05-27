package com.luoding.file;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Date：16-10-14
 * Time：上午11:10
 *
 * @author ding.luo@corp.luoding .com
 */
public class FileTest {

    public static void main(String [] args) throws IOException {
        String fileName = FileTest.class.getResource("/file/1.txt").getPath();
        System.out.println(fileName);
        String fileName1  = FileTest.class.getResource("/file/2.txt").getPath();
        BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName1))));

        List<String> ls1 = new ArrayList<String>();
        List<String> ls2 = new ArrayList<String>();

        String line = br1.readLine();
        while(!StringUtils.isBlank(line)){
            ls1.add(line);
            line = br1.readLine();
        }

        line = br2.readLine();
        while(!StringUtils.isBlank(line)){
            ls2.add(line);
            line = br2.readLine();
        }

        for(String s:ls1){
            if(!ls2.contains(s)){
                System.out.println(s);
            }
        }
    }

}

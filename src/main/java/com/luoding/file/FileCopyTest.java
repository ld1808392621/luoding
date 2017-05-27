package com.luoding.file;

import java.io.*;

/**
 * author: ding.luo
 * time: 17-2-22 下午3:55
 */
public class FileCopyTest {

    public static void main(String [] args) throws IOException {

        String fileName = FileCopyTest.class.getResource("/file/1.txt").getPath();
        System.out.println(fileName);
        String copyFileName = FileCopyTest.class.getResource("/file/copy.txt").getPath();
        File file = new File(fileName);
        File fileCopy = new File(copyFileName);
        fileCopy.createNewFile();
        copy(file,fileCopy);

    }


    public static void copy1(File file1,File file2) throws IOException {
        FileInputStream in = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);
        byte [] bytes = new byte[1024];
        while(true){
            int size = in.read(bytes);
            if(size <=0){
                break;
            }
            out.write(bytes, 0, size - 1);
            bytes = new byte[1024];
        }
        in.close();
        out.close();
    }


    public static void copy(File file1,File file2) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2)));
        String str = "";
        while(true){
            str = bufferedReader.readLine();
            if(null == str){
                break;
            }
            bufferedWriter.write(str);
            bufferedWriter.write("\n");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}

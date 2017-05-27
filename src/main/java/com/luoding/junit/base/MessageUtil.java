package com.luoding.junit.base;

/**
 * Date：16-9-27
 * Time：下午7:52
 *
 * @author ding.luo@corp.luoding .com
 */
public class MessageUtil {

    private String message;

    //Constructor
    //@param message to be printed
    public MessageUtil(String message){
        this.message = message;
    }

    // prints the message
    public String printMessage(){
        System.out.println(message);
        return message;
    }
}
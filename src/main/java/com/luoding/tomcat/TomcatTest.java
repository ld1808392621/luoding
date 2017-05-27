package com.luoding.tomcat;

import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.ContainerBase;
import org.apache.catalina.startup.Tomcat;
import org.apache.http.protocol.HttpProcessor;

/**
 * Date：16-9-14
 * Time：下午3:07
 *
 * @author ding.luo@corp.luoding .com
 */
public class TomcatTest {

    public static void main(String [] args){

        Tomcat tomcat = new Tomcat();
        Service service;
        Server server;
        Connector connector ;
        HttpProcessor httpProcessor;
        ContainerBase containerBase;
    }
}

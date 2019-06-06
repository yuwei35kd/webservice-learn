package com.webservice;

import javax.xml.ws.Endpoint;

public class TestMain {
    public static void main(String[] args) {
        //参数1：绑定服务的地址
        //参数2：提供services的实例
        Endpoint.publish("http://127.0.0.1:8080/webServer/services/HelloWebService", new HelloWebServiceImpl());
        //url的services是在web.xml中配置的路径
        //url的HelloWebService是与name（services.xml）对应的
        System.out.println("WebService服务启动");

    }
}

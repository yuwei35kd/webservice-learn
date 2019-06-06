package com.webservice;

import javax.jws.WebService;

@WebService(endpointInterface = "com.webservice.IHelloWebService")
public class HelloWebServiceImpl implements IHelloWebService {

    public String example(String message) {
        //处理逻辑
        return "Webservice 服务器返回的信息:" + message;
    }

}
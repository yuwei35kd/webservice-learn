package com.webservice.xfire.client;

import com.webservice.xfire.handler.MacAddressInjectHandler;
import com.webservice.xfire.handler.RequesterHeaderHandler;

public class XfireClient {
    public static void main(String[] args) {
        RequesterHeaderHandler r =
                new RequesterHeaderHandler("aaa", "111");
        HeaderHandlerResolver headerHandlerResolver = new HeaderHandlerResolver();
        headerHandlerResolver.addHandler(r);
        headerHandlerResolver.addHandler(new MacAddressInjectHandler());

        HelloWebService helloWebService = new HelloWebService();
        helloWebService.setHandlerResolver(headerHandlerResolver);
        HelloWebServicePortType helloWebServicePortType = helloWebService.getHelloWebServiceHttpPort();
        String result = helloWebServicePortType.example("hahhaha");
        System.out.println(result);
    }
}

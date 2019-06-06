package com.webservice.xfire.client;

public class XfireClient {
    public static void main(String[] args) {
        RequesterCredentials r =
                new RequesterCredentials("aaa", "111");
        HeaderHandlerResolver headerHandlerResolver = new HeaderHandlerResolver(r);

        HelloWebService helloWebService = new HelloWebService();
        //helloWebService.setHandlerResolver(headerHandlerResolver);
        HelloWebServicePortType helloWebServicePortType = helloWebService.getHelloWebServiceHttpPort();
        String result = helloWebServicePortType.example("hahhaha");
        System.out.println(result);
    }
}

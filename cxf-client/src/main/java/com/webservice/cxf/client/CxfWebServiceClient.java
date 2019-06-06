package com.webservice.cxf.client;

import com.webservice.cxf.client.wsdl2java.Greeting;
import com.webservice.cxf.client.wsdl2java.GreetingImplService;

public class CxfWebServiceClient {
    public static void main(String[] args) {

        GreetingImplService serviceFactory = new GreetingImplService();
        Greeting service = serviceFactory.getGreetingImplPort();
        String result = service.greeting("Jaune");
        System.out.println(result);

    }
}

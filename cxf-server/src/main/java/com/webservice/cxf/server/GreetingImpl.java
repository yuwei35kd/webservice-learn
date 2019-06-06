package com.webservice.cxf.server;

import java.util.Calendar;

import javax.jws.WebService;

@WebService(endpointInterface="com.webservice.cxf.server.Greeting")
public class GreetingImpl implements Greeting{

    public String greeting(String userName) {
        return "Hello " + userName + ", currentTime is "
                + Calendar.getInstance().getTime();
    }
}

package com.webservice.xfire.client;

import com.webservice.xfire.handler.MacAddressInjectHandler;
import com.webservice.xfire.handler.RequesterHeaderHandler;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderHandlerResolver implements HandlerResolver {
    /*private RequesterHeaderHandler requesterCredentials;
    private MacAddressInjectHandler macAddressInjectHandler;

    public HeaderHandlerResolver(RequesterHeaderHandler requesterCredentials){
        this.requesterCredentials=requesterCredentials;
    }*/

    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler){
        handlers.add(handler);
    }

    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        return handlers;
    }

}

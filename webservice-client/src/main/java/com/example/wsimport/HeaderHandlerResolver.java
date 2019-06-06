package com.example.wsimport;

import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.Arrays;
import java.util.List;

public class HeaderHandlerResolver implements HandlerResolver {
    private RequesterCredentials requesterCredentials;

    public HeaderHandlerResolver(RequesterCredentials requesterCredentials){
        this.requesterCredentials=requesterCredentials;
    }

    //@Override
    public List getHandlerChain(PortInfo portInfo) {
        return Arrays.asList(requesterCredentials);
    }

}

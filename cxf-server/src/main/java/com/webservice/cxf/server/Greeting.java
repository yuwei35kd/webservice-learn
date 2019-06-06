package com.webservice.cxf.server;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface Greeting {
    String greeting(@WebParam(name="username")String userName);
}

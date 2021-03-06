package com.webservice.cxf.client.wsdl2java;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2019-06-03T18:08:32.606+08:00
 * Generated source version: 3.3.2
 */
@WebService(targetNamespace = "http://server.cxf.webservice.com/", name = "Greeting")
@XmlSeeAlso({ObjectFactory.class})
public interface Greeting {

    @WebMethod
    @RequestWrapper(localName = "greeting", targetNamespace = "http://server.cxf.webservice.com/", className = "Greeting_Type")
    @ResponseWrapper(localName = "greetingResponse", targetNamespace = "http://server.cxf.webservice.com/", className = "GreetingResponse")
    @WebResult(name = "return", targetNamespace = "return")
    public java.lang.String greeting(

            @WebParam(name = "username", targetNamespace = "")
                    java.lang.String username
    );
}

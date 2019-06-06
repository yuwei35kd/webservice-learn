
package com.webservice.xfire.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWebServicePortType", targetNamespace = "http://webservice.com")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWebServicePortType {


    /**
     * 
     * @param in0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "http://webservice.com")
    @RequestWrapper(localName = "example", targetNamespace = "http://webservice.com", className = "com.example.xfire.Example")
    @ResponseWrapper(localName = "exampleResponse", targetNamespace = "http://webservice.com", className = "com.example.xfire.ExampleResponse")
    public String example(
            @WebParam(name = "in0", targetNamespace = "http://webservice.com")
                    String in0);

}
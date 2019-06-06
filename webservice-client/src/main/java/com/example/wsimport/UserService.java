
package com.example.wsimport;

import java.util.List;
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
@WebService(name = "UserService", targetNamespace = "http://service.server.webservice.example.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserService {


    /**
     * 
     * @return
     *     returns java.util.List<User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllUser", targetNamespace = "http://service.server.webservice.example.com/", className = "GetAllUser")
    @ResponseWrapper(localName = "getAllUserResponse", targetNamespace = "http://service.server.webservice.example.com/", className = "GetAllUserResponse")
    public List<User> getAllUser();

    /**
     * 
     * @param user
     * @return
     *     returns User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "generateUser", targetNamespace = "http://service.server.webservice.example.com/", className = "GenerateUser")
    @ResponseWrapper(localName = "generateUserResponse", targetNamespace = "http://service.server.webservice.example.com/", className = "GenerateUserResponse")
    public User generateUser(
        @WebParam(name = "user", targetNamespace = "")
        User user);

    /**
     * 
     * @param userId
     * @return
     *     returns User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUser", targetNamespace = "http://service.server.webservice.example.com/", className = "GetUser")
    @ResponseWrapper(localName = "getUserResponse", targetNamespace = "http://service.server.webservice.example.com/", className = "GetUserResponse")
    public User getUser(
        @WebParam(name = "userId", targetNamespace = "")
        String userId);

}

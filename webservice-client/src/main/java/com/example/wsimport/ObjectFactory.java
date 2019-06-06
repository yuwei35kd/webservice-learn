
package com.example.wsimport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.webserviceclient.wsimport package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllUser_QNAME = new QName("http://service.server.webservice.example.com/", "getAllUser");
    private final static QName _GenerateUser_QNAME = new QName("http://service.server.webservice.example.com/", "generateUser");
    private final static QName _GenerateUserResponse_QNAME = new QName("http://service.server.webservice.example.com/", "generateUserResponse");
    private final static QName _GetAllUserResponse_QNAME = new QName("http://service.server.webservice.example.com/", "getAllUserResponse");
    private final static QName _GetUserResponse_QNAME = new QName("http://service.server.webservice.example.com/", "getUserResponse");
    private final static QName _GetUser_QNAME = new QName("http://service.server.webservice.example.com/", "getUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.webserviceclient.wsimport
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link GetAllUser }
     * 
     */
    public GetAllUser createGetAllUser() {
        return new GetAllUser();
    }

    /**
     * Create an instance of {@link GenerateUser }
     * 
     */
    public GenerateUser createGenerateUser() {
        return new GenerateUser();
    }

    /**
     * Create an instance of {@link GenerateUserResponse }
     * 
     */
    public GenerateUserResponse createGenerateUserResponse() {
        return new GenerateUserResponse();
    }

    /**
     * Create an instance of {@link GetAllUserResponse }
     * 
     */
    public GetAllUserResponse createGetAllUserResponse() {
        return new GetAllUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.webservice.example.com/", name = "getAllUser")
    public JAXBElement<GetAllUser> createGetAllUser(GetAllUser value) {
        return new JAXBElement<GetAllUser>(_GetAllUser_QNAME, GetAllUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.webservice.example.com/", name = "generateUser")
    public JAXBElement<GenerateUser> createGenerateUser(GenerateUser value) {
        return new JAXBElement<GenerateUser>(_GenerateUser_QNAME, GenerateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenerateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.webservice.example.com/", name = "generateUserResponse")
    public JAXBElement<GenerateUserResponse> createGenerateUserResponse(GenerateUserResponse value) {
        return new JAXBElement<GenerateUserResponse>(_GenerateUserResponse_QNAME, GenerateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.webservice.example.com/", name = "getAllUserResponse")
    public JAXBElement<GetAllUserResponse> createGetAllUserResponse(GetAllUserResponse value) {
        return new JAXBElement<GetAllUserResponse>(_GetAllUserResponse_QNAME, GetAllUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.webservice.example.com/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.server.webservice.example.com/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

}

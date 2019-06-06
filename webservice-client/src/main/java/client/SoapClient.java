package client;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.net.URL;

public class SoapClient {

    private static String wsdlUrl = "http://localhost:8080/service/user?wsdl";
    public static void main(String[] args) throws Exception{
        String ns = "http://service.server.webservice.example.com/";
        MessageFactory factory = MessageFactory.newInstance();
        SOAPMessage message = factory.createMessage();
        SOAPPart part = message.getSOAPPart();
        SOAPEnvelope envelope = part.getEnvelope();
        SOAPBody body = envelope.getBody();
        QName qname = new QName(ns, "generateUser", "ser");
        SOAPBodyElement element = body.addBodyElement(qname);
        SOAPElement soapElement = element.addChildElement("user");
        soapElement.addChildElement("userId").setValue("2022");
        soapElement.addChildElement("age").setValue("12");
        soapElement.addChildElement("username").setValue("yuwei");
        soapElement.addChildElement("updateTime").setValue("2019-06-06T16:54:52.590+08:00");
        message.writeTo(System.out);
        //创建服务（Service）
        URL url = new URL(wsdlUrl);
        QName sname = new QName(ns,"UserServiceImplService");
        Service service = Service.create(url, sname);
        //创建Dispatch
        Dispatch<SOAPMessage> dispatch = service.
                createDispatch(new QName(ns,"UserServiceImplPort"),SOAPMessage.class,Service.Mode.MESSAGE);
        SOAPMessage response = dispatch.invoke(message);
        response.writeTo(System.out);
    }
}

package com.webservice.xfire.client;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Set;

//首先实现:添加头部逻辑
public class RequesterCredentials implements SOAPHandler<SOAPMessageContext> {
    private String user;
    private String password;

    public RequesterCredentials(String user, String password) {
        super();
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //@Override
    public Set<QName> getHeaders() {
        return null;
    }

    //@Override
    public void close(MessageContext context) {
    }

    //@Override
    public boolean handleFault(SOAPMessageContext context) {
        // TODO return true
        return true;
    }

    //@Override
    public boolean handleMessage(SOAPMessageContext context) {
        addRequesterCredentials(context);
        return true;
    }

    private void addRequesterCredentials(SOAPMessageContext context) {
        try {
            Boolean outboundProperty = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            if (outboundProperty.booleanValue()) {
                SOAPMessage message = context.getMessage();
                SOAPHeader header = message.getSOAPHeader();
                if (header == null) {
                    message.getSOAPPart().getEnvelope().addHeader();
                    header = message.getSOAPHeader();
                }
                SOAPElement authenticationToken = header.addChildElement("AuthenticationToken", "", "");
                authenticationToken.addChildElement("Username").addTextNode(user);
                authenticationToken.addChildElement("Password").addTextNode(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


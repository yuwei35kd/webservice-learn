package com.webservice.checkclient;

import org.apache.log4j.Logger;
import org.codehaus.xfire.MessageContext;
import org.codehaus.xfire.fault.XFireFault;
import org.codehaus.xfire.handler.AbstractHandler;
import org.jdom.Element;

public class ServerAuthenticationHandler extends AbstractHandler {
    private static final Logger log = Logger.getLogger(ServerAuthenticationHandler.class);

    public void invoke(MessageContext context) throws Exception {
        if (context.getInMessage().getHeader() == null) {
            throw new org.codehaus.xfire.fault.XFireFault("请求必须包含验证信息",
                    org.codehaus.xfire.fault.XFireFault.SENDER);
        }
        Element token = context.getInMessage().getHeader().getChild(
                "AuthenticationToken");
        if (token == null) {
            throw new org.codehaus.xfire.fault.XFireFault("请求必须包含身份验证信息",
                    org.codehaus.xfire.fault.XFireFault.SENDER);
        }
        String username = "";
        String password = "";
        Element usernameEle = token.getChild("Username");
        Element passwordEle = token.getChild("Password");
        if(usernameEle!=null){
            username = usernameEle.getValue();
        }
        if(passwordEle!=null){
            password = passwordEle.getValue();
        }
        if(username==null || username.length()==0){
            throw new XFireFault("用户名不能为空",
                    XFireFault.SENDER);
        }
        if(password==null || password.length()==0){
            throw new XFireFault("密码不能为空",
                    XFireFault.SENDER);
        }
        /**
         * 检查用户名密码是否正确
         */
        PasswordAuthenticationManager manager = new PasswordAuthenticationManager();
        if (!manager.verify(username, password)){
            throw new XFireFault("用户名密码错误，请重新确认",
                    XFireFault.SENDER);
        }
    }
}

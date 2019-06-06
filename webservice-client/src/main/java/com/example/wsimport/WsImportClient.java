package com.example.wsimport;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WsImportClient {
    public static void main(String[] args) {
        RequesterCredentials r = new RequesterCredentials("token", "user", "password");
        HeaderHandlerResolver headerHandlerResolver = new HeaderHandlerResolver(r);

        UserServiceImplService userServiceImplService = new UserServiceImplService();
        userServiceImplService.setHandlerResolver(headerHandlerResolver);
        UserService userService = userServiceImplService.getUserServiceImplPort();
        User user = userService.getUser("101");
        System.out.println(user.toString());

        System.out.println("=====================================================");

        user = new User();
        //user.setUpdateTime(xmlToDate(new Date()));
        user.setUpdateTime(null);
        user.setUsername("战三");
        user.setUserId("99999");
        user.setAge("100");
        User responseUser = userService.generateUser(user);
        System.out.println(responseUser.toString());

        /*SOAPEnvelope reqenvelope = msgContext.getEnvelope();
        if(reqenvelope != null){
            System.out.println("【client - request body start】");
            System.out.println(reqenvelope.getBody().toString());
            System.out.println("【client - request body end】");
        }*/
    }


    public static XMLGregorianCalendar xmlToDate(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar gc = null;
        try {
            gc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gc;
    }
}

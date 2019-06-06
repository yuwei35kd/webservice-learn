package com.webservice.checkclient;

public class PasswordAuthenticationManager {
    public  boolean verify(String username,String password){
        boolean flag=false;
        if("aaa".equals(username)&&"111".equals(password)){
            flag=true;
        }
        return flag;
    }
}

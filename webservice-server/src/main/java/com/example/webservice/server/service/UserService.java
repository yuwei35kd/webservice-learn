package com.example.webservice.server.service;

import com.example.webservice.server.domain.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface UserService {
    @WebMethod
    User getUser(@WebParam(name = "userId")String userId);

    @WebMethod
    ArrayList<User> getAllUser();

    @WebMethod
    User generateUser(@WebParam(name="user") User user);
}

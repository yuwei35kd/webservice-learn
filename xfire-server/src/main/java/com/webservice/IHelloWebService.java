package com.webservice;

import javax.jws.WebService;

@WebService
public interface IHelloWebService {
    public String example(String message);
}

package com.app.bean;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class MyCalculator {

    @WebMethod
    public int add(int a, int b){
        return a+b;
    }

}

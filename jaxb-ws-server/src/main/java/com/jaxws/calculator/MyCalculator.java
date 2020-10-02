package com.jaxws.calculator;

// JAX-WS

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class MyCalculator {

    @WebMethod
    public int add(int a, int b){
        System.out.println("add()");
        return a+b;
    }

    @WebMethod
    public int subtraction(int a, int b){
        System.out.println("subtraction()");
        return a-b;
    }

}

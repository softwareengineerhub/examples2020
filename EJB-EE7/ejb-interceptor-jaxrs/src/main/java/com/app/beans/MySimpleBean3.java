package com.app.beans;


import com.app.interceptor.MyInterceptor;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebMethod;
import javax.jws.WebService;

//@Stateless
//@WebService
public class MySimpleBean3 {

   // @WebMethod
    public int add(int a, int b){
        return a+b;
    }

}

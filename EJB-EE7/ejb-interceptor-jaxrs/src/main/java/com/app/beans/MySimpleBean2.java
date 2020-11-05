package com.app.beans;


import com.app.interceptor.MyInterceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(value = {MyInterceptor.class})
public class MySimpleBean2 {


    @Schedule(second = "*/10", minute = "*", hour = "*")
    public void myJob() {
        System.out.println("myJob");
    }

}

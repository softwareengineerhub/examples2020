package com.app.beans;


import com.app.interceptor.MyInterceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Asynchronous;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(value = {MyInterceptor.class})
public class MySimpleBean {

    @PostConstruct
    public void init(){
        System.out.println("MySimpleBean.init();hash="+hashCode());
    }


    public void doAction(){
        System.out.println("doAction();hash=" + hashCode());
    }

    //@Interceptors(value = {MyInterceptor.class})
    public int doAction2(){
        System.out.println("doAction()2;hash=" + hashCode());
        return 10;
    }

    //@Interceptors(value = {MyInterceptor.class})
    public int doAction3(int a, int b){
        System.out.println("doAction()2;hash=" + hashCode());
        return a+b;
    }


    @PreDestroy
    public void destroy(){
        System.out.println("MySimpleBean.destroy();hash="+hashCode());
    }

}

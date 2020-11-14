package com.app.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

@ApplicationScoped
//@RequestScoped
public class MyBean {

    @PostConstruct
    public void init(){
        System.out.println(hashCode()+"; @PostConstruct");
    }

    public int add(int a, int b){
        System.out.println("hashCode="+hashCode());
        return a+b;
    }

    @PreDestroy
    public void destroy(){
        System.out.println(hashCode()+"; @PreDestroy");
    }

}

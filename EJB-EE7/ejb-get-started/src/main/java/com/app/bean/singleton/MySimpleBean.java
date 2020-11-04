package com.app.bean.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
//@Startup
public class MySimpleBean {

    @PostConstruct
    public void init(){
        System.out.println("################MySimpleBean.init()");
    }

    public void doAction(){
        System.out.println("MySimpleBean.doAction()");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("################MySimpleBean.destroy()");
    }

}

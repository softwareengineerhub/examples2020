package com.app.service;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MySingleton {
   // @Autowired
   // private MyComponent myComponent;

    @Autowired
    private ApplicationContext applicationContext;


    public void doPrint(){
        MyComponent myComponent = applicationContext.getBean(MyComponent.class);
        System.out.println("value="+myComponent.getValue());
        System.out.println("hash="+myComponent.hashCode());
    }

    public void addValue(int value){
        MyComponent myComponent = applicationContext.getBean(MyComponent.class);
        myComponent.setValue(myComponent.getValue()+value);
    }

}

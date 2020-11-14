package com.app.bean5;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class MyEventListenerE {

    @Asynchronous
    public void onMessage(@Observes String text){
        try {
            System.out.println("ListenerE.start");
            Thread.sleep(15000);
            System.out.println("MyEventListenerE.text=" + text);
            System.out.println("ListenerE.finish");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

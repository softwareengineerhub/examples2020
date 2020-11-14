package com.app.bean5;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class MyEventListenerA {

    public void onMessage(@Observes String text){
        try {
            System.out.println("ListenerA.start");
            Thread.sleep(3000);
            System.out.println("MyEventListenerA.text=" + text);
            System.out.println("ListenerA.finish");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

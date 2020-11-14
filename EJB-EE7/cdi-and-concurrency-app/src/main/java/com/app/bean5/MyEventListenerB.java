package com.app.bean5;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class MyEventListenerB {

    public void onMessage(@Observes String text){
        try {
            System.out.println("ListenerB.start");
            Thread.sleep(3000);
            System.out.println("MyEventListenerB.text=" + text);
            System.out.println("ListenerB.finish");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

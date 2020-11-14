package com.app.bean5;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class MyEventListenerC {

    public void onMessage(@Observes String text){
        try {
            System.out.println("ListenerC.start");
            Thread.sleep(3000);
            System.out.println("MyEventListenerC.text=" + text);
            System.out.println("ListenerC.finish");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

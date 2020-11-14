package com.app.bean5;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@Stateless
public class MyEventListenerD {

    public void onMessage(@Observes String text){
        try {
            System.out.println("ListenerD.start");
            Thread.sleep(3000);
            System.out.println("MyEventListenerD.text=" + text);
            System.out.println("ListenerD.finish");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

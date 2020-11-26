package com.app.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

//@Component
public class MyQueueListener3 {

  //  @JmsListener(destination = "myQueue")
    public void onMessage(String msg){
        try {
            System.out.println("MyQueueListener3.START");
            Thread.sleep(1000);
            System.out.println("text=" + msg);
            System.out.println("MyQueueListener3.FINISH");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

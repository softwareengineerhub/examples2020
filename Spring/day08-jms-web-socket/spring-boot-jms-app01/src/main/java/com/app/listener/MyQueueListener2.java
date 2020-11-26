package com.app.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

//@Component
public class MyQueueListener2 {

  //  @JmsListener(destination = "myQueue")
    public void onMessage(Message msg){
        try {
            System.out.println("MyQueueListener2.START");
            Thread.sleep(7000);
            TextMessage message = (TextMessage) msg;
            String text = message.getText();
            System.out.println("text=" + text);
            System.out.println("MyQueueListener2.FINISH");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

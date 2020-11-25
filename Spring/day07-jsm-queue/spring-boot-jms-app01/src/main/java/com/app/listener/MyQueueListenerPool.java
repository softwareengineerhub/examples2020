package com.app.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MyQueueListenerPool {

    @JmsListener(destination = "myQueue", concurrency = "2-20")
    public void onMessage(Message msg){
        try {
            System.out.println("MyQueueListener.START; hash="+hashCode()+"; thread="+Thread.currentThread().getName());
            Thread.sleep(7000);
            TextMessage message = (TextMessage) msg;
            String text = message.getText();
            System.out.println("text=" + text);
            System.out.println("MyQueueListener.FINISH; hash="+hashCode()+"; thread="+Thread.currentThread().getName());
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

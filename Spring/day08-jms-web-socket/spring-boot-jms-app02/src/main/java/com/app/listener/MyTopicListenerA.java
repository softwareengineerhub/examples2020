package com.app.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MyTopicListenerA {

    @JmsListener(destination = "myTopic", containerFactory = "myTopicFactory")
    public void onMessage(Message msg){
        try {
            System.out.println("MyTopicListenerA.START");

            TextMessage message = (TextMessage) msg;
            String text = message.getText();
            System.out.println("text=" + text);
            System.out.println("MyTopicListenerA.FINISH");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

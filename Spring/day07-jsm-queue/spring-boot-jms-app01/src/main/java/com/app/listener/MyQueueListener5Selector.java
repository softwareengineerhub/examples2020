package com.app.listener;

import com.app.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

//@Component
public class MyQueueListener5Selector {

  //  @JmsListener(destination = "myQueue", selector = "type='B'")
    public void onMessage(Message msg){
        try {

            System.out.println("MyQueueListener5.START");
            TextMessage message = (TextMessage) msg;

            Thread.sleep(1000);
            System.out.println("text=" + message.getText());
            System.out.println("header; type=" + message.getStringProperty("type"));
            System.out.println("MyQueueListener5.FINISH");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

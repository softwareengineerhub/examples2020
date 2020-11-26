package com.app.listener;

import com.app.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class MyQueueListener4 {
    @Autowired
    private ObjectMapper objectMapper;

  //  @JmsListener(destination = "myQueue")
    public void onMessage(String jsonMsg){
        try {
            Person person = objectMapper.readValue(jsonMsg, Person.class);
            System.out.println("MyQueueListener4.START");
            Thread.sleep(1000);
            System.out.println("text=" + person);
            System.out.println("MyQueueListener4.FINISH");
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

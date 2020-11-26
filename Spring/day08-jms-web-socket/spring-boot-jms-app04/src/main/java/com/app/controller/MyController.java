package com.app.controller;

import com.app.model.Person;
import com.app.producer.MyProducer;
import com.app.producer.MyProducerWithHeader;
import com.app.producer.MyProducerWithTemplate;
import com.app.producer.MyProducerWithTemplate2;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;
import java.io.Serializable;
import java.util.Enumeration;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Queue queue;

    @GetMapping("/p4")
    public void sendMessage4(){
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueBrowser queueBrowser = session.createBrowser(queue, "myQueue");
            Enumeration enumeration = queueBrowser.getEnumeration();
            int count = 0;
            while(enumeration.hasMoreElements()){
                Object messageItem = enumeration.nextElement();
                System.out.println("messageItem="+messageItem);
                count++;
            }
            System.out.println("count="+count);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }


}

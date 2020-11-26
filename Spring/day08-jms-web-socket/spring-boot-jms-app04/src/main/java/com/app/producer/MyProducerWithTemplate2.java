package com.app.producer;

import com.app.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class MyProducerWithTemplate2 {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public void send(Person person) {
        jmsTemplate.send("myQueue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                try {
                    String text = objectMapper.writeValueAsString(person);
                    return session.createTextMessage(text);
                }catch (Exception ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }

}

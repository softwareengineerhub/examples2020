package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MyProducerWithHeader {
    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Destination destination;

    public void send(String text) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Message message = session.createTextMessage(text);
            message.setStringProperty("type", "A");
            //message.setStringProperty("type", "B");
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}

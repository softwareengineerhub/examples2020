package com.app.jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
public class MyProducerTopic {

    @Resource(name = "myConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "myTopic")
    private Destination destination;

    public void send(String text){
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Message message = session.createTextMessage(text);
            MessageProducer mp = session.createProducer(destination);
            mp.send(message);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }


}

package com.app.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MyTopicConsumerA implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage msg = (TextMessage) message;
            try {
                System.out.println("ConusmerA; Topic Messasge was consumed: "+msg.getText()+"; hashCode="+hashCode());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

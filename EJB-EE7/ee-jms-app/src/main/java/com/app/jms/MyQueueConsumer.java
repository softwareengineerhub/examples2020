package com.app.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MyQueueConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if(message instanceof TextMessage){
            TextMessage msg = (TextMessage) message;
            try {
             //   Thread.sleep(10000);
                System.out.println("Messasge was consumed: "+msg.getText()+"; hashCode="+hashCode());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

package com.app.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class AppConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory();
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("myTopic");
    }


    @Bean(name = "myTopicFactoryA")
    public JmsListenerContainerFactory<?> myTopicFactoryA(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setPubSubDomain(true);
        factory.setClientId("a");
        return factory;
    }

    @Bean(name = "myTopicFactoryB")
    public JmsListenerContainerFactory<?> myTopicFactoryB(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setPubSubDomain(true);
        factory.setClientId("b");
        return factory;
    }

    @Bean(name = "myTopicFactoryC")
    public JmsListenerContainerFactory<?> myTopicFactoryC(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setSubscriptionDurable(true);
        factory.setPubSubDomain(true);
        factory.setClientId("c");
        return factory;
    }
}

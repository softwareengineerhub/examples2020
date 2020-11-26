package com.app.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.QueueBrowser;

@Configuration
public class AppConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory();
    }

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("myQueue");
    }
}

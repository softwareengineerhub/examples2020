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

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private MyProducer myProducer;
    @Autowired
    private MyProducerWithTemplate myProducerWithTemplate;
    @Autowired
    private MyProducerWithTemplate2 myProducerWithTemplate2;
    @Autowired
    private MyProducerWithHeader myProducerWithHeader;


    @GetMapping("/p")
    public void sendMessage(){
        myProducer.send("Message: "+System.currentTimeMillis());
    }

    @GetMapping("/p2")
    public void sendMessage2(){
        myProducerWithTemplate.send("Message2: "+System.currentTimeMillis());
    }

    @GetMapping("/p3")
    public void sendMessage3(){
        Person person = new Person();
        person.setName("Name1");
        person.setAge(1);
        myProducerWithTemplate2.send(person);
    }

    @GetMapping("/p4")
    public void sendMessage4(){
        myProducerWithHeader.send("Message4: "+System.currentTimeMillis());
    }


}

package com.app.controller;

import com.app.producer.MyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private MyProducer myProducer;

    @GetMapping("/p")
    public void sendMessage(){
        myProducer.send("Message: "+System.currentTimeMillis());
    }

}

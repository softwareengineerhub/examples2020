package com.app.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/open")
public class OpenController {


    @GetMapping
    public String getMessage(Principal principal){
        return "This is my page; principal="+principal;
    }

}

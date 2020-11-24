package com.app.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@RequestMapping("/api")
public class MyController {


    @GetMapping("/all")
    public String getMessage(Principal principal){
        return "/api/all; user="+principal;
    }

    @GetMapping("/user")
    public String getMessageUser(HttpServletRequest req){
        String remoteUser = req.getRemoteUser();
        Principal principal = req.getUserPrincipal();
        return "/api/user; remoteUser="+remoteUser+"; principal="+principal.getName();
    }

    @GetMapping("/admin")
    public String getMessageAdmin(){
        return "/api/admin";
    }

    @GetMapping("/user-admin")
    public String getMessageUserAdmin(Principal principal){

        return "/api/user-admin; user="+principal.getName();
    }

}

package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class MyCalculatorService {

    public int add(int a, int b){
        System.out.println("a="+a);
        System.out.println("b="+b);
        int res = a+b;
        System.out.println("res="+res);
        return res;
    }

}

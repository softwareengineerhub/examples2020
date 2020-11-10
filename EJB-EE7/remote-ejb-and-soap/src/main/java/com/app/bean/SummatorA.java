package com.app.bean;

import javax.ejb.Stateless;

@Stateless(mappedName = "summatorA")
public class SummatorA implements Summator {

    @Override
    public int add(int a, int b) {
        System.out.println("summatorA.add()");
        return a+b;
    }
}

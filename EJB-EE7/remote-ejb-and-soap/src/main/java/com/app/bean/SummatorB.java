package com.app.bean;

import javax.ejb.Stateless;

@Stateless(mappedName = "summatorB")
public class SummatorB implements Summator {

    @Override
    public int add(int a, int b) {
        System.out.println("summatorB.add()");
        return a+b+10;
    }
}

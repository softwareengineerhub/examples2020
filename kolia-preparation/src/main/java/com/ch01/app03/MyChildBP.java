package com.ch01.app03;

public class MyChildBP extends MyBusinessProcessor {

    @Override
    public int processData(String str) {
        System.out.println("@Before calutation");
        return super.processData(str);
    }
}

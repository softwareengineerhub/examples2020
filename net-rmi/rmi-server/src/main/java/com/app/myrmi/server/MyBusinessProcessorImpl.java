package com.app.myrmi.server;

import com.app.common.BusinessProcessor;

import java.io.Serializable;

public class MyBusinessProcessorImpl implements BusinessProcessor, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public int add(int a, int b) {
        System.out.println(String.format("add(%s, %s)", a, b));
        return a+b;
    }

    @Override
    public int subtraction(int a, int b) {
        System.out.println(String.format("subtraction(%s, %s)", a, b));
        return a-b;
    }
}

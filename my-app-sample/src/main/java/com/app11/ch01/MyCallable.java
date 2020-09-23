package com.app11.ch01;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("MyCallable. START");
        Thread.sleep(5000);
        System.out.println("MyCallable. FINISH");
        return "hello";
    }
}

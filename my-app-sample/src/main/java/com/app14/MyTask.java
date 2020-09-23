package com.app14;

import java.util.concurrent.Callable;

public class MyTask implements Callable {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        System.out.println("START: "+name+"; thread="+Thread.currentThread());
        Thread.sleep(5000);
        System.out.println("FINISH: "+name+"; thread="+Thread.currentThread());
        return null;
    }
}

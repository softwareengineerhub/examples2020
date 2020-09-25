package com.app15.ch07;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        //int i=0;
        //i++;

        /*int res = atomicInteger.getAndIncrement();
        System.out.println("res="+res);
        System.out.println(atomicInteger.get());*/

        int res = atomicInteger.incrementAndGet();
        System.out.println("res="+res);
        System.out.println(atomicInteger.get());



    }
}

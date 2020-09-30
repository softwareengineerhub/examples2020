package com.app.myrmi.client;

import com.app.common.BusinessProcessor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {

    public static void main(String[] args) throws Exception {
        int a = 10;
        int b = 7;

        Registry registry = LocateRegistry.getRegistry(1099);
        BusinessProcessor businessProcessor = (BusinessProcessor) registry.lookup("myTest");
        System.out.printf("operands: %d, %d%n", a, b);
        System.out.println("add: " + businessProcessor.add(a, b));
        System.out.println("sub: " + businessProcessor.subtraction(a, b));
    }

}

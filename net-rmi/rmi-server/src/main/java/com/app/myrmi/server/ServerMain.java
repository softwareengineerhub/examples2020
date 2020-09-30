package com.app.myrmi.server;

import com.app.common.BusinessProcessor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain implements BusinessProcessor {

    public static void main(String[] args) throws Exception {

        ServerMain server = new ServerMain();
        BusinessProcessor bp = (BusinessProcessor) UnicastRemoteObject.exportObject(server, 0);

        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("myTest", bp);

        System.out.println("Server ready");
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public int add(int a, int b) {
        System.out.printf("add(%s, %s)%n", a, b);
        return a + b;
    }

    @Override
    public int subtraction(int a, int b) {
        System.out.printf("sub(%s, %s)%n", a, b);
        return a - b;
    }
}

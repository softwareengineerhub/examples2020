package com.app.myrmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {

    public static void main(String[] args) throws Exception {

        Registry registry = LocateRegistry.createRegistry(1099);
        //registry.rebind("businessProcessor", new MyBusinessProcessorImpl());
        registry.rebind("//127.0.0.1/myTest", new MyTestImpl());


        //registry.rebind("//127.0.0.1/MyPersonServer", new MyPersonServiceImpl());
        //Naming.rebind("//127.0.0.1/MyPersonServer", new MyPersonServiceImpl());
        System.out.println("Server ready");
        Thread.sleep(Integer.MAX_VALUE);
    }

}

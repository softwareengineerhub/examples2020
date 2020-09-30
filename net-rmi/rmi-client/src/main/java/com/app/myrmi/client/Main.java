package com.app.myrmi.client;

import com.app.common.BusinessProcessor;
import com.app.common.MyTest;

import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Permission;

public class Main {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry(1099);

        //Object remoteObject = registry.lookup("businessProcessor");
        //Remote remoteObject = registry.lookup("businessProcessor");
        //BusinessProcessor businessProcessor = (BusinessProcessor) registry.lookup("businessProcessor");
        MyTest myTest = (MyTest) registry.lookup("//127.0.0.1/myTest");
        myTest.doAction();
        //businessProcessor.test();
        //int sum = businessProcessor.add(1,2);
        //System.out.println("sum="+sum);
    }

}

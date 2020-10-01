package com.app.myrmi.client;

import com.app.common.*;

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

        System.out.println("------TEST-------------");
        MyTest myTest = (MyTest) registry.lookup("myTest");
        myTest.doAction();

        System.out.println("------BusinessProcessor-------------");
        BusinessProcessor businessProcessor = (BusinessProcessor) registry.lookup("businessProcessor");
        int sum = businessProcessor.add(1,2);
        System.out.println("sum="+sum);

        System.out.println("------PersonProcessor-------------");
        PersonProcessor personProcessor = (PersonProcessor) registry.lookup("personProcessor");
        PersonRequest request = new PersonRequest();
        request.setName("NameA");
        PersonResponse response = personProcessor.makeAction(request);
        System.out.println("status="+response.getStatus());
        System.out.println("date="+response.getDate());


    }

}

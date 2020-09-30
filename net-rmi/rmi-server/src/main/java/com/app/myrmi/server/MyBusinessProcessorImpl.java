package com.app.myrmi.server;

import com.app.common.BusinessProcessor;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyBusinessProcessorImpl extends UnicastRemoteObject implements BusinessProcessor, Serializable {

    private static final long serialVersionUID = 1L;

    public MyBusinessProcessorImpl() throws RemoteException {
    }

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

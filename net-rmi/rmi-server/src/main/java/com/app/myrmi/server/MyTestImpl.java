package com.app.myrmi.server;

import com.app.common.MyTest;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyTestImpl extends UnicastRemoteObject implements MyTest, Serializable {

    private static final long serialVersionUID = 1L;

    public MyTestImpl() throws RemoteException {
    }

    @Override
    public void doAction() throws RemoteException {
        System.out.println("doAction()");
    }
}

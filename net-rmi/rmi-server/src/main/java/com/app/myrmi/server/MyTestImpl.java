package com.app.myrmi.server;

import com.app.common.MyTest;

import java.io.Serializable;
import java.rmi.RemoteException;

public class MyTestImpl implements MyTest, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public void doAction() throws RemoteException {
        System.out.println("doAction()");
    }
}

package com.app.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyTest extends Remote {

    public void doAction() throws RemoteException;
}

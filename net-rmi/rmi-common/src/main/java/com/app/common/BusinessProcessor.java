package com.app.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BusinessProcessor extends Remote {

    public int add(int a, int b) throws RemoteException;

    public int subtraction(int a, int b) throws RemoteException;

}

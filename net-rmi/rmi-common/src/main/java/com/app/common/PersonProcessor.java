package com.app.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonProcessor extends Remote {


    public PersonResponse makeAction(PersonRequest personRequest) throws RemoteException;
}

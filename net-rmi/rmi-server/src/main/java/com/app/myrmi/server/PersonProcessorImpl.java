package com.app.myrmi.server;

import com.app.common.PersonProcessor;
import com.app.common.PersonRequest;
import com.app.common.PersonResponse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class PersonProcessorImpl extends UnicastRemoteObject implements PersonProcessor {

    public PersonProcessorImpl() throws RemoteException {
    }

    @Override
    public PersonResponse makeAction(PersonRequest personRequest) throws RemoteException {
        System.out.println("makeAction().personRequest="+personRequest.getName());
        PersonResponse response = new PersonResponse();
        response.setDate(new Date());
        response.setStatus("OK");
        return response;
    }
}

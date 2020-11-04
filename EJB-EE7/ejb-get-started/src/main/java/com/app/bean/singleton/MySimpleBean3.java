package com.app.bean.singleton;

import javax.ejb.*;
import java.util.concurrent.Future;

@Singleton
//@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class MySimpleBean3 {

    /*public synchronized void doAction3(){

    }*/

    @Lock(LockType.WRITE)
    public void doAction3(){
        System.out.println("MySimpleBean3.doAction3()");
    }



}

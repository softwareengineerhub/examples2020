package com.app.bean.singleton;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import java.util.concurrent.Future;

@Singleton
public class MySimpleBean2 {

    public void doAction2(){
        System.out.println("MySimpleBean2.doAction().START");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MySimpleBean2.doAction().FINISH");
    }


    @Asynchronous
    public void doAction2Asynch(){
        System.out.println("MySimpleBean2.doAction().START");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MySimpleBean2.doAction().FINISH");
    }

    @Asynchronous
    public Future<String> doAction2Asynch(int a){
        System.out.println("MySimpleBean2.doAction(a).START");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MySimpleBean2.doAction(a).FINISH");
        return new AsyncResult<>("Completed!!!");
    }










}

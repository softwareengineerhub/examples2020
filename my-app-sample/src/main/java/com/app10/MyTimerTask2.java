package com.app10;

import java.util.TimerTask;

public class MyTimerTask2 extends TimerTask {

    @Override
    public void run() {
        System.out.println("\tMyTask2; Thread="+Thread.currentThread());
    }
}

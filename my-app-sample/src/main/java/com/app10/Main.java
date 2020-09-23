package com.app10;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask();
        MyTimerTask2 myTimerTask2 = new MyTimerTask2();
        timer.scheduleAtFixedRate(myTimerTask, 0, 3000);
        timer.scheduleAtFixedRate(myTimerTask2, 0, 2000);

        myTimerTask.cancel();
        //timer.scheduleAtFixedRate(myTimerTask, 0, 3000);

       // timer.cancel();
    }
}

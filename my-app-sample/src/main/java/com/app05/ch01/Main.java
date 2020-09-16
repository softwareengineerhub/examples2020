package com.app05.ch01;

public class Main {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        MyProcessor myProcessor = new MyProcessor();
        //myProcessor.doAction1();
        //myProcessor.doAction2();
        MyThreadA myThreadA = new MyThreadA(myProcessor);
        MyThreadB myThreadB = new MyThreadB(myProcessor);
        //myThreadA.run();
        //myThreadB.run();


        //myThreadA.start();
        //myThreadB.start();

        myThreadA.start();
        myThreadB.start();

        myThreadA.join();
        myThreadB.join();


        System.out.println("-----------COMPLETED--------time:"+(System.currentTimeMillis()-start));
    }

}

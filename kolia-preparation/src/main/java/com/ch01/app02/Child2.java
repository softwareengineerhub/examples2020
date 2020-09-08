package com.ch01.app02;

public class Child2 extends Parent2 {

    public void doAction(){
        //System.out.println("@Before parent");
        long start = System.currentTimeMillis();
        super.doAction();
        System.out.println("time: "+(System.currentTimeMillis()-start));
        //System.out.println("@After parent");
    }

}

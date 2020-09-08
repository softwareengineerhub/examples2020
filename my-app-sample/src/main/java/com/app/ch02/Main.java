package com.app.ch02;


public class Main {

    public static void main(String[] args) {
        ChildA childA = new ChildA();
        childA.doAction();

        ChildB childB = new ChildB();
        childB.doAction();
        int res1 = childB.doAction("tttt");


        ChildA childB2 = new ChildB();
        childB2.doAction();

        int res2 = ((ChildB)childB2).doAction("Hello");
        System.out.println("res2="+res2);
        System.out.println("------------------------------");
        System.out.println("childA.i="+childA.i);
        System.out.println("childB.i="+childB.i);
        System.out.println("childB2.i="+childB2.i);

    }

}

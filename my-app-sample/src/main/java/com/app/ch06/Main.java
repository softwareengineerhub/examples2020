package com.app.ch06;

public class Main {

    public static void main(String[] args) {
        Helper6.doAction1();
        int t = Helper6.i;

        Helper6 helper = new Helper6();
        //helper.doAction();
        helper.j++;
        Helper6.i++;

        Helper6 helper2 = new Helper6();
        //helper.doAction();
        helper2.j++;
        Helper6.i++;

        System.out.println("static i="+Helper6.i);
        System.out.println("helper.j="+helper.j);
        System.out.println("helper2.j="+helper.j);
    }

}

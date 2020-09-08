package com.app.ch09;

public class Main {

    public static void main(String[] args) {
        MyInter9 myInter9 = new MyInter9ImplA();
        myInter9 = new MyInter9ImplB();


        MyInter9Second myInter9Second = new MyInter9ImplA();
    }


    private void doCalc(MyInter9 myInter9){
        myInter9.m1();
    }

    private void doCalc(MyInter9Second myInter9Second){
        myInter9Second.n1();
    }



}

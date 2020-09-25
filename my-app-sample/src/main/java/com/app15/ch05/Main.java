package com.app15.ch05;

public class Main {

    public static void main(String[] args) {
        MyData myData = new MyData();
        ChangeMaker cm = new ChangeMaker(myData);
        ChangeListener changeListener = new ChangeListener(myData);

        changeListener.start();
        cm.start();
    }

}

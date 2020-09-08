package com.app.ch13;

public class Main {

    public static void main(String[] args) {
        MyData myData = MyData.A;
        switch (myData){
            case A:
                System.out.println("A");
            case B:
                System.out.println("C");
        }

        MyData[] values = MyData.values();
        for(MyData value: values){
            System.out.println(value);
        }

    }
}

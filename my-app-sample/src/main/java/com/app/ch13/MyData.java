package com.app.ch13;

public enum MyData {

    A, B(1), C(2);
    private int i;


    MyData(){
        System.out.println("Creating of value");
    }

    MyData(int i){
        System.out.println("Creating of value; i="+i);
        this.i=i;
    }

    public void doAction(){
     //   t
        System.out.println();
    }

    @Override
    public String toString() {
        return "MyData{" +
                "i=" + i +
                '}';
    }
}

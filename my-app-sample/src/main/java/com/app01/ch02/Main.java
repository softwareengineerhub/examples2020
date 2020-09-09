package com.app01.ch02;

public class Main {

    public static void main(String[] args) {
        MyPerson myPerson1 = new MyPerson("Name1", 1);
        //System.out.println(myPerson.toString());
        System.out.println(myPerson1);
        MyPerson myPerson2 = new MyPerson("Name2", 2);
        MyPerson myPerson3 = new MyPerson("Name2", 2);

        System.out.println(myPerson1==myPerson2);
        System.out.println(myPerson1.equals(myPerson2));
        System.out.println("--------------------");
        System.out.println(myPerson3==myPerson2);
        System.out.println(myPerson3.equals(myPerson2));

        myPerson3.equals(myPerson3);


    }



}

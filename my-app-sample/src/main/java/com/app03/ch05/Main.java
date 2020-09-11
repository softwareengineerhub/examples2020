package com.app03.ch05;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MyData myData = new MyData("MyDescription");
       MyTv myTv = new MyTv( "Name1", 1, myData);
       // myTv.setAge(1);
        //myTv.setName("Name1");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("tv.txt")));
        out.writeObject(myTv);

        System.out.println("-------------------------------------");

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("tv.txt")));
        Object obj = in.readObject();
        MyTv myTv2 = (MyTv) obj;
        //System.out.println(myTv2.getAge());
        //System.out.println(myTv2.getName());
        System.out.println(myTv2);
    }

}

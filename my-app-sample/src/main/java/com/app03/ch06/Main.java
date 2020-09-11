package com.app03.ch06;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        MyChild06 myChild06 = new MyChild06();
        myChild06.setAge(1);
        myChild06.setName("Name1");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("parent-child.txt")));
        out.writeObject(myChild06);
        System.out.println("--------------------------");

        ObjectInputStream  in = new ObjectInputStream(new FileInputStream(new File("parent-child.txt")));
        MyChild06 res = (MyChild06) in.readObject();
        System.out.println(res);
    }
}

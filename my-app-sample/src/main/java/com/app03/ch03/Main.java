package com.app03.ch03;

import com.app03.ch02.MyUser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("myuser2.txt");
        /*MyUser2 myUser2 = new MyUser2();
        myUser2.setAge(1);
        myUser2.setName("Name1");
        write(file, myUser2);
        MyUser2 myUser2Res = read(file);
        System.out.println(myUser2Res);*/



        //List<MyUser2> list = initUsers(10);
        //write(file, list);
        List<MyUser2> list = readBulk(file);
        for(MyUser2 myUser2: list){
            System.out.println(myUser2);
        }

    }

    private static MyUser2 read(File file) throws  Exception {
        try(DataInputStream in = new DataInputStream(new FileInputStream(file))){
            int age = in.readInt();
            String name = in.readUTF();
            MyUser2 myUser2 = new MyUser2();
            myUser2.setName(name);
            myUser2.setAge(age);
            return myUser2;
        }
    }

    private static List<MyUser2> readBulk(File file) throws  Exception {
        try(DataInputStream in = new DataInputStream(new FileInputStream(file))){
            List<MyUser2> list = new ArrayList<>();
            int n = in.readInt();
            for(int i=0;i<n;i++){
                int age = in.readInt();
                String name = in.readUTF();
                MyUser2 myUser2 = new MyUser2();
                myUser2.setName(name);
                myUser2.setAge(age);
                list.add(myUser2);
            }

            return list;
        }
    }

    private static void write(File file, MyUser2 myUser2) throws Exception {
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(file))){
            out.writeInt(myUser2.getAge());
            out.writeUTF(myUser2.getName());
        }
    }


    private static void write(File file, List<MyUser2> list) throws Exception {
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(file))){
            out.writeInt(list.size());
            for(MyUser2 myUser2: list) {
                out.writeInt(myUser2.getAge());
                out.writeUTF(myUser2.getName());
            }
        }
    }


    private static List<MyUser2> initUsers(int n){
        List<MyUser2> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            MyUser2 myUser2 = new MyUser2();
            myUser2.setAge(i);
            myUser2.setName("Name"+i);
            list.add(myUser2);
        }
        return list;
    }

}

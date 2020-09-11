package com.app03.ch05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyTv implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient MyData myData;

    public MyTv(){
        System.out.println("Constructor()");
    }

    public MyTv(String name, int age, MyData myData) {
        System.out.println("Constructor(name, age, myData)");
        this.myData=myData;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyData getMyData() {
        return myData;
    }

    public void setMyData(MyData myData) {
        this.myData = myData;
    }


    private void writeObject(ObjectOutputStream out){
        try {
            out.defaultWriteObject();
            out.writeUTF(myData.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream in){
        try {
            in.defaultReadObject();
            String description = in.readUTF();
            myData = new MyData(description);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "MyTv{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", myData=" + myData +
                '}';
    }
}

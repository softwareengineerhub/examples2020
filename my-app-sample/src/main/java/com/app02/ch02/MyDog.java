package com.app02.ch02;

public class MyDog implements Comparable{

    private String name;
    private int age;

    public MyDog(String name, int age) {
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

    @Override
    public String toString() {
        return "MyDog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object obj) {
        if(obj==null){
            return 1;
        }
        if(obj==this){
            return 0;
        }
        if(obj.getClass()==MyDog.class){
            MyDog myDog = (MyDog) obj;
            if(myDog.age==age){
                return name.compareTo(myDog.name);
            }else{
                return age-myDog.age;
            }
        }
        return -1;
    }
}

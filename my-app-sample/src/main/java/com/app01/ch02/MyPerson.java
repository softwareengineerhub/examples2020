package com.app01.ch02;

import java.util.Objects;

public class MyPerson {

    private String name;
    private int age;

    public MyPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public MyPerson(){
    }

    public String getName(){
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


    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(obj==this){
            return true;
        }
        if(obj.getClass()==MyPerson.class){
            MyPerson other = (MyPerson) obj;
            if(other.age!=age){
                return false;
            }

            if(other.name==null && name==null){
                return true;
            }

            if(other.name!=null){
                return other.name.equals(name);
            }

            if(name!=null){
                return name.equals(other.name);
            }

        }
        return false;
    }





    @Override
    public int hashCode() {
        int hash = (name == null ? 0 : name.hashCode());
        /*int hash1 = 0;
        if(name==null){
            hash1=0;
        }else{
            hash1 = name.hashCode();
        }*/
        return hash+age;
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

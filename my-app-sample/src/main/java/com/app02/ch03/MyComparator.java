package com.app02.ch03;

import java.util.Comparator;

public class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        MyPhone myPhone1 = (MyPhone) o1;
        MyPhone myPhone2 = (MyPhone) o2;
        if(myPhone1.getAge()==myPhone2.getAge()){
            return -(myPhone1.getName().compareTo(myPhone2.getName()));
        }else{
            return -(myPhone1.getAge()-myPhone2.getAge());
        }
    }
}

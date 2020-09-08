package com.ch01.app04;

import java.util.LinkedList;

public class MyStack {
    private LinkedList data = new LinkedList();


    public void push(Object item){
        data.add(item);
    }

    public Object peek(){
      return data.getLast();
    }

    public Object pop(){
        return data.removeLast();
    }


    public boolean isEmpty(){
        return data.isEmpty();
    }

    public int size(){
        return data.size();
    }


}

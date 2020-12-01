package com.example.stack;

import java.util.LinkedList;

public class MyStack2 {
    private LinkedList data = new LinkedList();


    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void push(Object item) {
        data.add(item);
    }

    public Object pop() {
        return data.removeLast();
    }

    public Object peek() {
        return data.getLast();
    }

}

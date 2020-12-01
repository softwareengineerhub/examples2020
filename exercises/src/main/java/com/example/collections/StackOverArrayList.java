package com.example.collections;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOverArrayList<T> extends ArrayList<T> implements IStack<T> {

    private static final long serialVersionUID = -52253473984446292L;

    public StackOverArrayList() {
    }

    @Override
    public void push(T element) {
        add(element);
    }

    @Override
    public T pop(){
        int len = size();
        T element = peek();
        remove(len-1);
        return element;
    }

    // return element on top of stack without removing
    @Override
    public T peek() {
        int len = size();
        if (len == 0) throw new EmptyStackException();
        return get(len - 1);
    }
}

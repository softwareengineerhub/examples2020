package com.example.stack;

import java.awt.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;

public class StackOverLinkedList<T> extends LinkedList<T> implements IStack<T> {

    private static final long serialVersionUID = -1490780483371107703L;

    public StackOverLinkedList() {
    }

    @Override
    public void push(T t) {
        super.push(t);
    }

    public T pop() {
        return super.pop();
    }

    // return element on top of stack without removing
    public T peek() {
        return super.peek();
    }
}

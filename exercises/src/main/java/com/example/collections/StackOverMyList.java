package com.example.collections;

import java.io.Serializable;
import java.util.EmptyStackException;

public class StackOverMyList<T> extends MyList<T> implements IStack<T>, Serializable {

    private static final long serialVersionUID = -1490780483371107703L;

    public StackOverMyList() {
    }

    @Override
    public void push(T t) {
        super.addFirst(t);
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    // return element on top of stack without removing
    @Override
    public T peek() {
        if (first == null) throw new EmptyStackException();
        return first.element;
    }
}

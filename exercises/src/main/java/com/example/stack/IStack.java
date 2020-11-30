package com.example.stack;

import java.util.List;

public interface IStack<T> extends List<T> {
    void push(T element);

    T pop();

    // return element on top of stack without removing
    T peek();
}

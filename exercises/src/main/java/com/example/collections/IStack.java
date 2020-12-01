package com.example.collections;

public interface IStack<T>  {
    void push(T element);

    T pop();

    // return element on top of stack without removing
    T peek();
}

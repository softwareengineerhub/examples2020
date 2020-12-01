package com.example.stack;

import java.util.Arrays;

public class MyStack1 {
    private Object[] data;
    private int size;
    private int capacity;

    public MyStack1(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyStack1() {
        this(10);
    }

    public void push(Object item) {
        if (size == data.length) {
            //увелиыиваем длину массива (создаем новый) и копируем содержимое старого массива
            data = Arrays.copyOf(data, data.length + capacity);
        }
        data[size] = item;
        size++;
    }

    public Object pop() {
        Object item = data[size - 1];
        data[size - 1] = null;
        size--;
        return item;
    }

    public Object peek() {
        return data[size - 1];
    }

}

package com.app06.ch02.prod.consumer;

public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();
        Producer producer  = new Producer(monitor);
        Consumer consumer = new Consumer(monitor, producer);
        producer.start();
        consumer.start();
    }
}

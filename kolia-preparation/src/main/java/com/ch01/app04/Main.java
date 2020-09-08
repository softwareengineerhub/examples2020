package com.ch01.app04;

public class Main {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        System.out.println("isEmpty="+myStack.isEmpty());
        System.out.println("size="+myStack.size());
        System.out.println("peek="+myStack.peek());
        System.out.println("isEmpty="+myStack.isEmpty());
        System.out.println("size="+myStack.size());

        System.out.println("pop="+myStack.pop());
        System.out.println("pop="+myStack.pop());
        System.out.println("pop="+myStack.pop());

    }

}

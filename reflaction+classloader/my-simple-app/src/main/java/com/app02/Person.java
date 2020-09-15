package com.app02;

public class Person {

    static {
        System.out.println("static{}");
        //String s = null;
        //s.toString();
    }

    public Person() {
        System.out.println("\tConstructor");
    }

    public Person(int type) {
        System.out.println("\tConstructor(int);type="+type);
    }

    public int age;
    private int height;
    private final int width = 1;

    private void doAction(){
        System.out.println("doAction()");
    }

    public void process(){
        System.out.println("process()");
    }

    public void process(String name){
        System.out.println("process();name="+name);
    }

    public String process(String name, int age){
        System.out.println("process();name="+name+";age="+age);
        return "Hello";
    }

}

package com.jaxws.detector;

public class Person {
    private String name;
    private int iq;

    public Person() {
    }

    public Person(String name, int iq) {
        super();
        this.name = name;
        this.iq = iq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", iq=" + iq +
                '}';
    }

}

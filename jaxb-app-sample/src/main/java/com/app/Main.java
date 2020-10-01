package com.app;

public class Main {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Name1");
        person.setAge(1);
        person.setGender("A");

        XmlConverter xmlConverter = new XmlConverter();
        xmlConverter.toXml(person);

        Person res = xmlConverter.fromXml();
        System.out.println(res);
    }

}

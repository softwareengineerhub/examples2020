package com.app02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {
        //Person p = new Person();

        String str = "com.app02.Person";
        Class cl = Class.forName(str);
        //Object obj = cl.newInstance();
        Person obj = (Person) cl.newInstance();
        Person obj1 = (Person) cl.newInstance();

        System.out.println("----------field. public--------------------");
        Field field = cl.getDeclaredField("age");

        field.set(obj, 1);
        field.set(obj1, 2);
        //obj.age=1;
        //obj1.age=2;

        Integer age = (Integer) field.get(obj);
        Integer age1 = (Integer) field.get(obj1);

        System.out.println("age="+age);
        System.out.println("age1="+age1);

        System.out.println("----------field. private--------------------");
        Field heightField = cl.getDeclaredField("height");
        heightField.setAccessible(true);
        heightField.set(obj, 5);
        int height = heightField.getInt(obj);
        System.out.println("height="+height);


        System.out.println("----------field. private final--------------------");
        Field widthField = cl.getDeclaredField("width");
        widthField.setAccessible(true);
        widthField.set(obj, -5);
        int width = widthField.getInt(obj);
        System.out.println("width="+width);

        System.out.println("-----------------Method----------------------------------");
        Method m = cl.getDeclaredMethod("doAction");
        m.setAccessible(true);
        m.invoke(obj);

        System.out.println("-----------------Method override----------------------------------");
        m = cl.getDeclaredMethod("process");
        Object res = m.invoke(obj);
        System.out.println("res="+res);

        System.out.println("---------------Method with param------------------");
        m = cl.getDeclaredMethod("process", String.class);
        //p.process("sadasd");
        //p.process();
        res = m.invoke(obj, "MyName");
        System.out.println("res="+res);


        System.out.println("---------------Method with 2 params------------------");
        m = cl.getDeclaredMethod("process", String.class, int.class);
        res = m.invoke(obj, "MyName", 10);
        System.out.println("res="+res);

        System.out.println("---------------Constructor overload------------------");
        Constructor constructor = cl.getDeclaredConstructor(int.class);
        Object obj2 = constructor.newInstance(20);
        System.out.println(obj2);


    }

}

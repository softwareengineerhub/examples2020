package com.app03.ch04;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        /*Properties props = new Properties();
        props.put("name", "Name1");
        props.put("age", "Age1");
        OutputStream out =new FileOutputStream(new File("data.properties"));
        String comments = "test";
        props.store(out, comments);*/

        Properties props = new Properties();
        props.load(new FileInputStream(new File("data.properties")));
        for(Object key: props.keySet()){
            System.out.println(key+"="+props.getProperty(key+""));
        }
        System.out.println(props.getProperty("qqqq", "TESTQQQ"));

    }
}

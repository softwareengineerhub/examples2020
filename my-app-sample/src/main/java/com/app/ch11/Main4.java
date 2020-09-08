package com.app.ch11;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main4 {

    public static void main(String[] args) {
        try {
            System.out.println("try");
            m();
            System.out.println("after m");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }

    }


    public static void m() throws Exception {
            File f = new File("data.txt");
            InputStream in = new FileInputStream(f);
            in.read();
    }

}

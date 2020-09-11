package com.app03.ch01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class MainWrite {


    public static void main(String[] args) throws Exception {
        try(OutputStream out = new FileOutputStream(new File("data.txt"));) {
            String text = "test data"+System.currentTimeMillis();
            out.write(text.getBytes());
        }
    }

    /*public static void main(String[] args) throws Exception {
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File("data.txt"));
            String text = "test data";
            out.write(text.getBytes());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }*/


    /*public static void main(String[] args) throws Exception {
        OutputStream out = new FileOutputStream(new File("data.txt"));
        String text = "test data";
        out.write(text.getBytes());
        out.close();
    }*/


}

package com.app.ch11;

import java.io.*;

public class Main3 {

    /*public static void main(String[] args) {
        try {
            File f = new File("data.txt");
            InputStream in = new FileInputStream(f);
            in.read();
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }*/

    public static void main(String[] args) throws Exception {
            File f = new File("data.txt");
            InputStream in = new FileInputStream(f);
            in.read();
    }

}

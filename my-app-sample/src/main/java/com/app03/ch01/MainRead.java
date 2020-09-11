package com.app03.ch01;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainRead {

    public static void main(String[] args) throws Exception {
        URL url = MainRead.class.getResource("/data.txt");
        //String filePath = url.getFile();
        //System.out.println(filePath);
        Path path = Paths.get(url.toURI());
        byte[] data = Files.readAllBytes(path);
        System.out.println(new String(data));


        /*try(InputStream in = MainRead.class.getResourceAsStream("/data.txt");){
            int n = in.available();
            byte[] data = new byte[n];
            in.read(data);
            String content = new String(data);
            System.out.println(content);
        }*/

    }

    /*public static void main(String[] args) throws Exception {
        try(InputStream in = new FileInputStream(new File("data.txt"));) {
            int n = in.available();
            byte[] data = new byte[n];
            in.read(data);
            String content = new String(data);
            System.out.println(content);
        }
    }*/



}

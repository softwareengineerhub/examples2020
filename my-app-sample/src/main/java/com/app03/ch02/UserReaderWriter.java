package com.app03.ch02;

import java.io.*;

public class UserReaderWriter {
    private File file;

    public UserReaderWriter(File file) {
        this.file = file;
    }

    public void write(MyUser myUser) throws Exception {
        try(OutputStream out = new FileOutputStream(file)){
            String s = "name="+myUser.getName();
            s+="; age="+myUser.getAge();
            out.write(s.getBytes());
        }
    }

    public MyUser read() throws Exception {
        try(InputStream in = new FileInputStream(file)){
            byte[] data = new byte[in.available()];
            in.read(data);
            String content = new String(data);
            String[] arr  = content.split(";");
            String name = arr[0].split("=")[1];
            String ageValue = arr[1].split("=")[1];
            int age = Integer.parseInt(ageValue);
            MyUser myUser = new MyUser();
            myUser.setName(name);
            myUser.setAge(age);
            return myUser;
        }
    }
}

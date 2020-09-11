package com.app03.ch02;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("myuser.txt");
        UserReaderWriter userReaderWriter = new UserReaderWriter(file);
        MyUser myUser = new MyUser();
        myUser.setAge(1);
        myUser.setName("Name1");
        userReaderWriter.write(myUser);
        System.out.println("---------------------------");
        MyUser myUser1 = userReaderWriter.read();
        System.out.println(myUser1);
    }
}

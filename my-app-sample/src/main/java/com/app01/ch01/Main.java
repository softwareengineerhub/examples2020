package com.app01.ch01;

public class Main {

    public static void main(String[] args) {
        String s = "A";
        String s2 = new String("A");
        boolean res = s==s2;
        boolean res2 = s.equals(s2);
        System.out.println("res="+res);
        System.out.println("res2="+res2);
        System.out.println("---------");
        String s3 = "A";
        String s4 = new String("A");
        System.out.println(s3==s);
        System.out.println(s4==s2);
        System.out.println(s4.equals(s2));
    }

}

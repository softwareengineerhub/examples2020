package com.app.jsp.api;

public class MyHelper {

    public String doAction(){
        System.out.println("doAction()");
        return "doAction;"+hashCode();
    }

    public static String doAction2(){
        System.out.println("doAction2()");
        return "doAction2";
    }

}

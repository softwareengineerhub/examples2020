package com.ch01.app03;

public class MyComposition {

    private MyBusinessProcessor myBusinessProcessor = new MyBusinessProcessor();

    public int calculateN(String str){
        return myBusinessProcessor.processData(str);
    }

}

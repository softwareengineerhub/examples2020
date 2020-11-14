package com.app.bean4;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Tag
public class PhoneA implements Phone {

    @Override
    public void call() {
        System.out.println("A.call()");
    }
}

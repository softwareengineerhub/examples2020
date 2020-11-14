package com.app.bean4;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Tag2
public class PhoneB implements Phone {

    @Override
    public void call() {
        System.out.println("B.call()");
    }
}

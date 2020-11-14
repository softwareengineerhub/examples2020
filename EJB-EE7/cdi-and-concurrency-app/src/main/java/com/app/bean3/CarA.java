package com.app.bean3;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named(value = "a")
public class CarA implements Car {

    @Override
    public void drive() {
        System.out.println("drive.A");
    }
}

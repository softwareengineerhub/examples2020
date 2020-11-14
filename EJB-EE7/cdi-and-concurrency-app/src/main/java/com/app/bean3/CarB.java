package com.app.bean3;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("b")
public class CarB implements Car {

    @Override
    public void drive() {
        System.out.println("drive.B");
    }
}

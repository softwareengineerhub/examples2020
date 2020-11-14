package com.app.bean2;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;

@ApplicationScoped
@Any
public class DataProcessorB implements DataProcessor {

    @Override
    public void doAction() {
        System.out.println("dataProcessorB");
    }
}

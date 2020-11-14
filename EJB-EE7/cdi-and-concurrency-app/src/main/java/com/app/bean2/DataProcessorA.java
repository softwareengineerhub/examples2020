package com.app.bean2;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;

@ApplicationScoped
@Default
public class DataProcessorA implements DataProcessor {

    @Override
    public void doAction() {
        System.out.println("dataProcessorA");
    }
}

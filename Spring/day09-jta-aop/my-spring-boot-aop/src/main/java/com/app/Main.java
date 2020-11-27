package com.app;

import com.app.service.MyCalculatorService;
import com.app.service.MySingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private MyCalculatorService myCalculatorService;

    @Autowired
    private MySingleton mySingleton;

    @Override
    public void run(String... args) throws Exception {
        /*long start = System.currentTimeMillis();
        int sum = myCalculatorService.add(1,2);
        System.out.println("sum="+sum);
        System.out.println("time="+(System.currentTimeMillis()-start));*/

        mySingleton.addValue(10);
        mySingleton.doPrint();
        System.out.println("-------------");
        mySingleton.addValue(15);
        mySingleton.doPrint();
    }
}

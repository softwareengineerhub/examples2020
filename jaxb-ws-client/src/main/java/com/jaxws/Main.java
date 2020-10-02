package com.jaxws;

import com.jaxws.calculator.MyCalculator;
import com.jaxws.calculator.MyCalculatorService;
import com.jaxws.detector.Capability;
import com.jaxws.detector.DumbDetector;
import com.jaxws.detector.DumbDetectorService;
import com.jaxws.detector.Person;

//wsimport http://127.0.0.1:8084/calc?wsdl -keep
public class Main {

    public static void main(String[] args) {
        MyCalculatorService  myCalculatorService = new MyCalculatorService();
        MyCalculator myCalculator = myCalculatorService.getMyCalculatorPort();

        int res = myCalculator.add(1, 5);
        System.out.println("res="+res);

        DumbDetectorService dumbDetectorService = new DumbDetectorService();
        DumbDetector dumbDetector = dumbDetectorService.getDumbDetectorPort();
        Person person = new Person();
        person.setName("John Dow");
        person.setIq(80);
        Capability capability = dumbDetector.detect(person);
        System.out.println(person.getName()+" is "+capability.value());
    }

}
package org.client;

import com.app.MyCalculator;
import com.app.MyCalculatorService;
import com.app.ObjectFactory;

//wsimport http://127.0.0.1:8084/calc?wsdl -keep
public class Main {

    public static void main(String[] args) {
        MyCalculatorService  myCalculatorService = new MyCalculatorService();
        MyCalculator myCalculator = myCalculatorService.getMyCalculatorPort();

        int res = myCalculator.add(1, 5);
        System.out.println("res="+res);

    }

}

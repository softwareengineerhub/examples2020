package com.jaxws;

import com.jaxws.calculator.MyCalculator;
import com.jaxws.detector.DumbDetector;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8084/calc", new MyCalculator());
        Endpoint.publish("http://127.0.0.1:8084/detector", new DumbDetector());
    }
}

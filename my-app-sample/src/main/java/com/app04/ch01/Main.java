package com.app04.ch01;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        //File file = new File("car.xml");
        File file = new File("car.json");

        Car car = new Car("Name3", 3);

      //  DataProcessor dataProcessor = DataProcessorFactory.getDataProcessor(DataProcessorType.XML_SAX, file);
     //   DataProcessor dataProcessor = DataProcessorFactory.getDataProcessor(DataProcessorType.XML_DOM, file);
        DataProcessor dataProcessor = DataProcessorFactory.getDataProcessor(DataProcessorType.JSON, file);
        System.out.println("-----write----------");
        dataProcessor.write(car);
        System.out.println("-----read----------");
        Car car1 = dataProcessor.read();
        System.out.println(car1);
    }

}

package com.app04.ch01;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        runListDemo(DataProcessorType.JSON, "cars.json");
        runListDemo(DataProcessorType.XML_DOM, "cars_dom.xml");
        runListDemo(DataProcessorType.XML_SAX, "cars_sax.xml");
    }

    public static void runListDemo(DataProcessorType dataProcessorType, String filename) {
        File file = new File(filename);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1", 10));
        cars.add(new Car("Car2", 11));
        cars.add(new Car("Car3", 23));
        cars.add(new Car("Car4", 34));

        DataProcessor dataProcessor = DataProcessorFactory.getDataProcessor(dataProcessorType, file);
        System.out.println("\nDemo of " + dataProcessorType);

        System.out.println("-----write----------");
        System.out.println(cars);
        dataProcessor.write(cars);
        cars.clear();

        System.out.println("-----read----------");
        List<Car> readerCars = dataProcessor.readBulk();
        System.out.println(readerCars);
    }

}

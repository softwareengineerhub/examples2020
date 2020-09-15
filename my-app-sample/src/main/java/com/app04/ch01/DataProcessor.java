package com.app04.ch01;

import java.util.List;

public interface DataProcessor {

    void write(Car car);

    void write(List<Car> cars);

    Car read();

    List<Car> readBulk();
}

package com.app04.ch01;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JsonDataProcessor implements DataProcessor {

    private final File file;
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonDataProcessor(File file) {
        this.file = file;
    }

    @Override
    public void write(Car car) {
        try {
            mapper.writeValue(file, car);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void write(List<Car> cars) {
        try {
            mapper.writeValue(file, cars);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Car read() {
        try {
            return mapper.readValue(file, Car.class);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Car> readBulk() {
        try {
            return Arrays.asList(mapper.readValue(file, Car[].class));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}

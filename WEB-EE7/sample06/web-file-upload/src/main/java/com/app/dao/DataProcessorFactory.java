package com.app.dao;

public class DataProcessorFactory {


    public static DataProcessor dataProcessor(String type) {
        if ("json".equalsIgnoreCase(type)) {
            return new JsonDataProcessor();
        }
        if ("xml".equalsIgnoreCase(type)) {
            return new XmlDataProcessor();
        }
        if ("csv".equalsIgnoreCase(type)) {
            return new CsvDataProcessor();
        }
        if ("xls".equalsIgnoreCase(type)) {
            return new XlsDataProcessor();
        }
        if ("properties".equalsIgnoreCase(type)) {
            return new PropertiesDataProcessor();
        }

        throw new IllegalArgumentException("No dataProcessor defined for type="+type);
    }
}

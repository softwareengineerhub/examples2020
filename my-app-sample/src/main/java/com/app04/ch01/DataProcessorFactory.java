package com.app04.ch01;

import java.io.File;

public class DataProcessorFactory {


    public static DataProcessor getDataProcessor(DataProcessorType dataProcessorType, File file){
        switch(dataProcessorType){
            case XML_SAX:
                return new XmlSaxDataProcessor(file);
            case XML_DOM:
                return new XmlDomDataProcessor(file);
            case JSON:
                return new JsonDataProcessor(file);
            default:
                throw new IllegalArgumentException("Incorrect type: "+dataProcessorType);
        }
    }
}

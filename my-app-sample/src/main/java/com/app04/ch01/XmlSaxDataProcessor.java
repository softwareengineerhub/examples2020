package com.app04.ch01;

import com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlSaxDataProcessor extends AbstractXmlDataProcessor {

    public XmlSaxDataProcessor(File file) {
        super(file);
    }

    @Override
    public Car read() {
        try {
            SAXParserFactory saxParserFactory = new SAXParserFactoryImpl();
            SAXParser parser = saxParserFactory.newSAXParser();
            Car car = new Car();

            parser.parse(file, new DefaultHandler() {

                String lastTag;

                @Override
                public void startDocument() throws SAXException {
                    System.out.println("START DOCUMENT");
                }

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    lastTag = qName;
                    System.out.println("\tstartElement:" + qName);
                    int n = attributes.getLength();
                    System.out.println("\tAttributes: length=" + n);

                    for (int i = 0; i < n; i++) {
                        String key = attributes.getQName(i);
                        String val = attributes.getValue(i);
                        System.out.println("\t\t" + key + "=" + val);

                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String val = new String(ch, start, length).trim();
                    if (!val.isEmpty()) {
                        System.out.println("\t\t\tval=" + val);

                        if ("name".equals(lastTag)) {
                            car.setName(val);
                        } else if ("age".equals(lastTag)) {
                            car.setAge(Integer.parseInt(val));
                        }

                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("\tendElement:" + qName);
                }

                @Override
                public void endDocument() throws SAXException {
                    System.out.println("END DOCUMENT");
                }
            });

            return car;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Car> readBulk() {

        List<Car> cars = new ArrayList<>();

        try {
            SAXParserFactory saxParserFactory = new SAXParserFactoryImpl();
            SAXParser parser = saxParserFactory.newSAXParser();

            parser.parse(file, new DefaultHandler() {

                Car car;
                String lastTag;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    lastTag = qName;
                    if ("Car".equals(qName)) {
                        car = new Car();
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String val = new String(ch, start, length).trim();
                    if (!val.isEmpty()) {
                        if ("name".equals(lastTag)) {
                            car.setName(val);
                        } else if ("age".equals(lastTag)) {
                            car.setAge(Integer.parseInt(val));
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if ("Car".equals(qName)) {
                        cars.add(car);
                    }
                }

            });

            return cars;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

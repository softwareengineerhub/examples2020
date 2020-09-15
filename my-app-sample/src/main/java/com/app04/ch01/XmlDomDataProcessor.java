package com.app04.ch01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlDomDataProcessor extends AbstractXmlDataProcessor{


    public XmlDomDataProcessor(File file) {
        super(file);
    }


    @Override
    public Car read() {
        try {
            Car car = new Car();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("car");
            int n = nList.getLength();
            System.out.println("n="+n);
            for(int i=0;i<n;i++){
                Node child = nList.item(i);
                //NodeList childList = child.getChildNodes();

                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) child;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String ageVal = eElement.getElementsByTagName("age").item(0).getTextContent();
                    car.setName(name);
                    car.setAge(Integer.parseInt(ageVal));

                }


            }

            System.out.println("----------------------------");

            return car;
        }catch (Exception ex){
            throw  new RuntimeException(ex);
        }
    }

}

package com.app;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

public class XmlConverter {
    private File file = new File("person.xml");

    public void toXml(Person person){
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(person, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Person fromXml(){
        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object res = unmarshaller.unmarshal(file);
            return (Person) res;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}

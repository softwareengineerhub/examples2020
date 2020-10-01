/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import generated.Person;
import java.math.BigInteger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller m = context.createMarshaller();
        Person person = new Person();
        person.setAge(BigInteger.valueOf(1));
        person.setName("Name1");
        person.setGender2("A");
        m.marshal(person, System.out);
        
    }
    
}

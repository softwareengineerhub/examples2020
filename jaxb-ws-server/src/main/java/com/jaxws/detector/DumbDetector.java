package com.jaxws.detector;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class DumbDetector {

    @WebMethod
    public Capability detect(Person person) {
        int smartLevel = Math.min(person.getIq() / 30, 4);
        return Capability.values()[smartLevel];
    }

    @WebMethod
    public Capability guess(Person person) {
        int smartLevel = (int) (Math.floor(Math.random() * 4) + 1);
        return Capability.values()[smartLevel];
    }
}

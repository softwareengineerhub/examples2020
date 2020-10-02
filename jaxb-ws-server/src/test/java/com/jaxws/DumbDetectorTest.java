package com.jaxws;

import com.jaxws.detector.Capability;
import com.jaxws.detector.DumbDetector;
import com.jaxws.detector.Person;

import static org.junit.Assert.*;

public class DumbDetectorTest {

    private static final int REPEATS = 1000;

    @org.junit.Test
    public void detect() {
        Person person = new Person("Ivanov", 50);
        DumbDetector detector = new DumbDetector();
        assertEquals(detector.detect(person), Capability.DUMB);
        assertNotEquals(detector.detect(person), Capability.STUPID);
        person.setIq(200);
        assertEquals(detector.detect(person), Capability.GENIUS);
    }

    @org.junit.Test
    public void testGuess() {
        Person person = new Person("Ivanov", 50);
        DumbDetector detector = new DumbDetector();
        for (int i = 0; i < REPEATS; i++) {
            Capability cp = detector.guess(person);
            assertTrue(cp.compareTo(Capability.DUMB) >= 0
            && cp.compareTo(Capability.GENIUS) <= 0);
        }
    }
}
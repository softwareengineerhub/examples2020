package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void getElementN() {
        assertEquals(Fibonacci.getElementN(0), 0);
        assertEquals(Fibonacci.getElementN(1), 1);
        assertEquals(Fibonacci.getElementN(2), 1);
        assertEquals(Fibonacci.getElementN(3), 2);
        assertEquals(Fibonacci.getElementN(4), 3);
        assertEquals(Fibonacci.getElementN(5), 5);
        assertEquals(Fibonacci.getElementN(7), 13);
        assertEquals(Fibonacci.getElementN(19), 4181);
        assertEquals(Fibonacci.getElementN(40), 102334155);
    }

    @Test
    public void getElementRecursive() {
        assertEquals(Fibonacci.getElementRecursive(0), 0);
        assertEquals(Fibonacci.getElementRecursive(1), 1);
        assertEquals(Fibonacci.getElementRecursive(4), 3);
        assertEquals(Fibonacci.getElementRecursive(7), 13);
        assertEquals(Fibonacci.getElementRecursive(19), 4181);
        assertEquals(Fibonacci.getElementRecursive(40), 102334155);
    }
}
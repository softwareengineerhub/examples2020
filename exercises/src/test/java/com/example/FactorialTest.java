package com.example;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class FactorialTest {

    @Test
    public void getFactorialN() {
        assertEquals(Factorial.getFactorialN(0),BigInteger.valueOf(0));
        assertEquals(Factorial.getFactorialN(1),BigInteger.valueOf(1));
        assertEquals(Factorial.getFactorialN(2),BigInteger.valueOf(2));
        assertEquals(Factorial.getFactorialN(3),BigInteger.valueOf(6));
        assertEquals(Factorial.getFactorialN(5),BigInteger.valueOf(120));
        assertEquals("1124000727777607680000", Factorial.getFactorialN(22).toString());
    }
}
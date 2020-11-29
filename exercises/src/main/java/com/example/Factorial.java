package com.example;

import java.math.BigInteger;

/*
 * https://oeis.org/A000142/list
 * */
public class Factorial {

    public static BigInteger getFactorialN(int n) {
        if (n < 2) return BigInteger.valueOf(n);
        else return BigInteger.valueOf(n).multiply(getFactorialN(n - 1));
    }
}

package com.example;

/*
 * https://oeis.org/A000045/list
 * */
public class Fibonacci {

    public static long getElementN(int n) {
        long previous = 0;
        if (n == 0) return previous;
        long current = 1;
        if (n == 1) return current;
        for (int i = 2; i <= n; i++) {
            long tmp = current;
            current = current + previous;
            previous = tmp;
        }
        return current;
    }

    public static long getElementRecursive(int n) {
        if (n < 2) return n;
        else return (getElementRecursive(n - 1) + getElementRecursive(n - 2));
    }

}

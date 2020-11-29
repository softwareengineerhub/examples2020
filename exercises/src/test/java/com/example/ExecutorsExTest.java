package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class ExecutorsExTest {

    public static final int SIZE = 1000000;

    ExecutorsEx executorsEx = new ExecutorsEx();
    ThreadLocalRandom random = ThreadLocalRandom.current();

    @Test
    public void checkAddMachineRandom3() {
        double[] a = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            a[i] = random.nextDouble(1);
        }
        double correctAnswer = Arrays.stream(a).sum();
        double supposition = executorsEx.addMachine(a, 3);
        assertEquals(supposition, correctAnswer, 0.000001);
    }

    @Test
    public void checkAddMachineRandomFaster() {
        double[] a = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            a[i] = random.nextDouble(1);
        }
        double correctAnswer = Arrays.stream(a).sum();
        long start = System.currentTimeMillis();

        double supposition = 0;
        for (int i = 0; i < 1000; i++) {
            supposition = executorsEx.addMachine(a, 1);
        }
        long time1 = System.currentTimeMillis() - start;
        System.out.println("1 thread: " + time1 + " ms");
        assertEquals(supposition, correctAnswer, 0.000001);

        start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            supposition = executorsEx.addMachine(a, 4);
        }
        long time4 = System.currentTimeMillis() - start;
        System.out.println("4 threads: " + time4 + " ms");
        assertEquals(supposition, correctAnswer, 0.000001);
        assertTrue(time1 / (double) time4 > 1.7);
    }

    @Test
    public void checkAddMachine100() {
        double[] a = new double[SIZE];
        for (int i = 0; i < 100; i++) a[i] = i + 1;
        assertEquals(executorsEx.addMachine(a, 8), (1 + 100) * 100 / 2.0, 0.000001);
    }
}
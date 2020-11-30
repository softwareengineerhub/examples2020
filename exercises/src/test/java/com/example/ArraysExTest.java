package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class ArraysExTest {

    private static final int SIZE = 100;
    private static final int ITERATIONS = 100;
    final ArraysEx arraysEx = new ArraysEx();

    @Test
    public void deduplication() {
        int[] a = {1, 2, 3, 1, 2, 3};
        int[] sample = {1, 2, 3};
        assertArrayEquals(arraysEx.deduplication(a), sample);
    }

    @Test
    public void deduplication2() {
        int[] a = {1, 1, 1, 2, 2, 2, 3, 3};
        int[] sample = {1, 2, 3};
        assertArrayEquals(arraysEx.deduplication(a), sample);
    }

    @Test
    public void deduplicationStream() {
        int[] a = {1, 2, 3, 1, 2, 3};
        int[] sample = {1, 2, 3};
        assertArrayEquals(arraysEx.deduplicationStream(a), sample);
    }

    @Test
    public void performanceCheck() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] duplicated = new int[SIZE];
        long start = System.currentTimeMillis();

        // generate new array
        for (int i = 0; i < SIZE; i++) duplicated[i] = random.nextInt(SIZE / 3);
        int[] deduplicated = arraysEx.deduplicationStream(duplicated);

        IntStream.range(0, ITERATIONS).forEach(iter -> assertArrayEquals(arraysEx.deduplication(duplicated), deduplicated));
        System.out.println("time of {while}: " + (System.currentTimeMillis() - start));

        IntStream.range(0, ITERATIONS).forEach(iter -> assertArrayEquals(arraysEx.deduplicationStream(duplicated), deduplicated));

        System.out.println("time of {stream}: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void commonOf() {
        int[] a = {1, 2, 3, 4, 5, 6, 8};
        int[] b = {2, 6, 8, 4, 16, 78, 8, 66, 8};
        int[] common = {2, 4, 6, 8};
        assertArrayEquals(arraysEx.commonOf(a, b), common);
    }

    @Test
    public void findSecondMaximum() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(arraysEx.findSecondMaximum(a), 7);
    }

    @Test
    public void findSecondMaximum2() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int attempt = 0; attempt < 1000; attempt++) {
            int[] ints = IntStream.range(0, 500).map(i -> random.nextInt(1000)).distinct().toArray();
            int supposition = ints[arraysEx.findSecondMaximum(ints)];
            Arrays.sort(ints);
            assertEquals(ints[ints.length - 2], supposition);
        }
    }

}
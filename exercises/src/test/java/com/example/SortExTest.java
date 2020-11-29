package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class SortExTest {

    public static final int STREAM_SIZE = 1_000_000;
    SortEx<Integer> sortEx = new SortEx<>();

    @Test
    public void searchRandomElementInSortedArray() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        IntStream a = random.ints(STREAM_SIZE).distinct().sorted();
        Integer[] sorted = a.boxed().toArray(Integer[]::new);
        IntStream.range(0, 1_000_000).map(i -> random.nextInt(sorted.length-1)).forEach(correctIndex -> {
            Integer sample = sorted[correctIndex];
            try {
                assertEquals(sortEx.searchInSortedArray(sorted, sample), correctIndex);
            } catch (NoSuchElementException e) {
                System.out.println("Not found element at index "+correctIndex);
            }
        });
    }

    @Test
    public void searchEveryElementInSortedArray() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        IntStream a = random.ints(STREAM_SIZE).distinct().sorted();
        Integer[] sorted = a.boxed().toArray(Integer[]::new);
        IntStream.range(0, sorted.length).forEach(correctIndex -> {
            Integer sample = sorted[correctIndex];
            try {
                assertEquals(sortEx.searchInSortedArray(sorted, sample), correctIndex);
            } catch (NoSuchElementException e) {
                System.out.println("Not found element at index "+correctIndex);
            }
        });
    }

    @Test
    public void bubbleSort() {
        Integer[] sorted = {0,1,2,3,4,5,6,7,8,9};
        assertArrayEquals(sorted, sortEx.bubbleSort(sorted));

        Integer[] b = {0,9,8,7,6,5,4,3,2,1};
        assertArrayEquals(sorted, sortEx.bubbleSort(b));
    }

    @Test
    public void selectionSort() {
        Integer[] sorted = {0,1,2,3,4,5,6,7,8,9};
        assertArrayEquals(sorted, sortEx.selectionSort(sorted));

        Integer[] b = {0,9,8,7,6,5,4,3,2,1};
        assertArrayEquals(sorted, sortEx.selectionSort(b));

        ThreadLocalRandom random = ThreadLocalRandom.current();
        Integer[] c = random.ints().boxed().limit(100).toArray(Integer[]::new);
        Integer[] d = sortEx.selectionSort(c);
        Arrays.sort(c);
        assertArrayEquals(c, sortEx.selectionSort(d));
    }

    @Test
    public void mergeSortedArrays() {
        int[] a = {1, 3, 5, 7, 9, 11, 13, 15, 17, 18, 19};
        int[] b = {2, 4, 6, 8, 10, 12, 14, 16, 20};
        int[] c = sortEx.mergeArrays(a, b);
        int[] sorted = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                .sorted().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(c));
        assertArrayEquals(c, sorted);
    }

    @Test
    public void mergeRandomSortedArrays() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] a = random.ints(100).sorted().toArray();
        int[] b = random.ints(100).sorted().toArray();
        int[] c = sortEx.mergeArrays(a, b);
        int[] sorted = Stream.concat(Arrays.stream(a).boxed(), Arrays.stream(b).boxed())
                .sorted().mapToInt(i -> i).toArray();
        assertArrayEquals(c, sorted);
    }

}
package com.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SummaFromArrayTest {

    public static final int REQUIRED_SUM = 20;
    SummaFromArray summaFromArray = new SummaFromArray();

    @Test
    public void testRemoveElement() {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = summaFromArray.removeElement(a, 5);
        int[] c = {0, 1, 2, 3, 4, 6, 7, 8, 9};
        assertArrayEquals(b, c);
    }

    @Test
    public void addElement() {
        int[] a = {1};
        a = summaFromArray.addElement(a, 2);
        a = summaFromArray.addElement(a, 3);
        a = summaFromArray.addElement(a, 4);
        a = summaFromArray.addElement(a, 5);
        int[] c = {1, 2, 3, 4, 5};
        assertArrayEquals(a, c);
    }

    @Test
    public void checkVariants() {
        int[] coins = {1, 2, 5, 10, 2, 2, 5, 10, 5};
        int[] variants = {};
        summaFromArray.getVariants(REQUIRED_SUM, coins, variants);
        assertEquals(summaFromArray.getAnswers().size(), 4);
        System.out.println("How to make " + REQUIRED_SUM + " from " + Arrays.toString(coins)+":");
        for (String result : summaFromArray.getAnswers())
            System.out.println(result);

    }

    @Test
    public void permutation() {
        System.out.println("All variants:");
        int[] source = {1, 2, 3};
        int[] destination = {};
        summaFromArray.permutation(destination, source);
    }
}
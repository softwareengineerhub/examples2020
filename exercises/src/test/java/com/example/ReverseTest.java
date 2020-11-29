package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ReverseTest {

    Reverse reverse = new Reverse();

    @Test
    public void reverseString1() {
        assertEquals(reverse.reverseString1("abcdefgh"), "hgfedcba");
        assertNotEquals(reverse.reverseString1("abcdefgh"), "hgfedcbaa");
    }

    @Test
    public void reverseLong() {
        assertEquals(reverse.reverseLong(12345), 54321);
        assertEquals(reverse.reverseLong(987654321), 123456789);
    }

    @Test
    public void reverseList() {
        assertTrue(reverseTest(reverse::reverseList));
    }

    @Test
    public void reverseListStack() {
        assertTrue(reverseTest(reverse::reverseListStack));
    }

    private boolean reverseTest(Function<List<Integer>, List<Integer>> f) {
        ArrayList<Integer> testList = (ArrayList<Integer>) IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        ArrayList<Integer> reversed = (ArrayList<Integer>) IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        Collections.reverse(reversed);
        List<Integer> response = f.apply(testList);
        return IntStream.range(0, testList.size()).allMatch(i -> response.get(i).equals(reversed.get(i)));
    }

    @Test
    public void digitsCount() {
        assertEquals(reverse.digitsCount(123), 6);
        assertEquals(reverse.digitsCount(123123123123L), 24);
        assertEquals(reverse.digitsCount(9999999999L), 90);
    }

}
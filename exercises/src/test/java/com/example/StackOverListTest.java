package com.example;

import com.example.collections.StackOverMyList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackOverListTest {

    public static final int STACK_SIZE = 10;

    @Test
    public void checkPush() {
        StackOverMyList<Integer> stack = new StackOverMyList<>();
        assertEquals(stack.size(), 0);
        for (int i = 0; i < STACK_SIZE; i++) {
            stack.push(i);
        }
        assertEquals(stack.size(), STACK_SIZE);
    }

    @Test
    public void testPeek() {
        StackOverMyList<Integer> stack = new StackOverMyList<>();
        for (int i = 0; i < STACK_SIZE; i++) {
            stack.push(i);
            assertEquals((int) stack.peek(), i);
        }
    }

    @Test
    public void testPop() {
        StackOverMyList<Integer> stack = new StackOverMyList<>();
        for (int i = 0; i < STACK_SIZE; i++)
            stack.push(i);

        assertEquals(stack.size(), STACK_SIZE);

        for (int i = 0; i < STACK_SIZE; i++)
            assertEquals((int) stack.pop(), STACK_SIZE - 1 - i);
    }

}
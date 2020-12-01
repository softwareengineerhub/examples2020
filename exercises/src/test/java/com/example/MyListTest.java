package com.example;

import com.example.collections.MyList;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MyListTest {

    @Test
    public void add() {
        MyList<Integer> list = new MyList<>();
        assertEquals(list.size(), 0);
        assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) list.add(i);
        assertEquals(list.size(), 10);
        assertFalse(list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkGet() {
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        list.get(45);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkGetFromEmpty() {
        MyList<Integer> list = new MyList<>();
        list.get(1);
    }

    @Test
    public void checkSet() {
        MyList<Integer> list = new MyList<>();
        IntStream.range(1, 10).forEach(list::add);
        assertTrue(list.set(7, 45));
        list.set(2, 145);
        assertEquals((int) list.get(2), 145);
        assertEquals((int) list.get(7), 45);
    }

    @Test
    public void checkRemove() {
        MyList<Integer> list = new MyList<>();
        IntStream.range(0, 10).forEach(list::add);
        int r = list.remove(1);
        assertEquals(r, 1);
        list.remove(5);
        assertEquals((int) list.get(7), 9);
        assertEquals((int) list.get(7), 9);
        System.out.println(list.toString());
    }

    @Test
    public void checkToString() {
        MyList<Integer> list = new MyList<>();
        assertEquals(list.toString(), "[]");
        IntStream.range(0, 10).forEach(list::add);
        assertEquals(list.toString(), "[0,1,2,3,4,5,6,7,8,9]");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkRemoveOutOfBounds() {
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 10; i++) list.add(i);
        list.remove(10);
    }

    @Test
    public void checkAddFirst(){
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 10; i++) list.addFirst(i);
        assertEquals(list.toString(), "[9,8,7,6,5,4,3,2,1,0]");
    }

    @Test
    public void checkPeek(){
        MyList<Integer> list = new MyList<>();
        for (int i = 0; i < 10; i++) list.addFirst(i);
        assertEquals(list.toString(), "[9,8,7,6,5,4,3,2,1,0]");
    }

}
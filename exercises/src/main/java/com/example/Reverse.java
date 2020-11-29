package com.example;

import java.util.*;

public class Reverse {

    public String reverseString1(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    public long reverseLong(final long source) {
        long l = source;
        long result = 0;
        do {
            long r = l % 10;
            l = l / 10;
            result = (result * 10) + r;
        }
        while (l > 0);
        return result;
    }

    public List<Integer> reverseList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) result.add(0, integer);
        return result;
    }

    public List<Integer> reverseListStack(List<Integer> list) {
        LinkedList<Integer> result = new LinkedList<>();
        for (Integer integer : list) result.push(integer);
        return result;
    }

    public int digitsCount(long source) {
        long l = source;
        int result = 0;
        do {
            long r = l % 10;
            l = l / 10;
            result += r;
        }
        while (l > 0);
        return result;
    }

}

package com.example;

import java.util.Arrays;

public class ArraysEx {

    public int[] deduplication(final int[] a) {
        int size = a.length;
        int i = 0;
        while (i < size) {
            int j = i + 1;
            while (j < size) {
                if (a[j] == a[i]) {
                    if (size - 1 - j >= 0) System.arraycopy(a, j + 1, a, j, size - 1 - j);
                    size--;
                } else j++;
            }
            i++;
        }
        return Arrays.copyOf(a, size);
    }

    public int[] deduplicationStream(final int[] a) {
        return Arrays.stream(a).distinct().toArray();
    }

    public int[] commonOf(int[] a, int[] b) {
        return (a.length < b.length) ? compare(a, b) : compare(b, a);
    }

    // здесь точно а короче b
    private int[] compare(final int[] a, final int[] b) {
        int[] result = new int[a.length];
        int[] workB = Arrays.copyOf(b, b.length);
        int indexResult = 0;
        int size = b.length;
        for (int k : a) {
            int j = 0;
            while (j < size) {
                if (k == workB[j]) {
                    if (size - 1 - j >= 0) System.arraycopy(workB, j + 1, workB, j, size - 1 - j);
                    size--;
                    result[indexResult++] = k;
                    break;
                } else j++;
            }
        }
        return Arrays.copyOf(result, indexResult);
    }

    public int findSecondMaximum(int[] a) {
        int firstMaxIndex = 0;
        int secondMaxIndex = 0;
        int firstMaxValue = Integer.MIN_VALUE;
        int secondMaxValue = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > secondMaxValue) {
                if (a[i] > firstMaxValue) {
                    secondMaxValue = firstMaxValue;
                    secondMaxIndex = firstMaxIndex;
                    firstMaxIndex = i;
                    firstMaxValue = a[i];
                } else {
                    secondMaxValue = a[i];
                    secondMaxIndex = i;
                }
            }
        }
        return secondMaxIndex;
    }

}

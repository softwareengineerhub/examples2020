package com.example;

import java.util.NoSuchElementException;

public class SortEx<T extends Comparable<T>> {

    private void swap(T[] a, int i, int j) {
        T tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public int[] mergeArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        while (indexC < c.length)
            c[indexC++] = (indexA < a.length && a[indexA] < b[indexB]) ? a[indexA++] : b[indexB++];
        return c;
    }

    public T[] bubbleSort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j].compareTo(a[i]) < 0) swap(a, i, j);
            }
        }
        return a;
    }

    public T[] selectionSort(T[] a) {
        for (int i = 0; i < a.length; i++) {

            // находим минимальый элемент на участке от i+1 до конца списка
            int minIndex = i;
            T min = a[minIndex];
            for (int j = i + 1; j < a.length; j++) {
                if (min.compareTo(a[j]) > 0) {
                    min = a[j];
                    minIndex = j;
                }
            }
            swap(a, i, minIndex);
        }

        return a;
    }


    int searchInSortedArray(T[] a, T sample) {
        int leftIndex = 0;
        int rightIndex = a.length;
        while (rightIndex - leftIndex > 1) {
            int index = (rightIndex + leftIndex) / 2;
            switch (a[index].compareTo(sample)) {
                case 1:
                    rightIndex = index;
                    break;
                case -1:
                    leftIndex = index;
                    break;
                default:
                    return index;
            }
        }
        if (a[leftIndex].compareTo(sample) == 0) return leftIndex;
        throw new NoSuchElementException();
    }
}

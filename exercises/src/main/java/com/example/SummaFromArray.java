package com.example;

import java.util.*;

public class SummaFromArray {

    Set<String> answers = new HashSet<>();

    void getVariants(int required, int[] coins, int[] variants) {

        if (Arrays.stream(coins).sum() < required) return;

        for (int i = 0; i < coins.length; i++) {

            if (coins[i] == required) {
                int[] result = addElement(variants, coins[i]);
                answers.add(Arrays.toString(Arrays.stream(result).sorted().toArray()));
            }

            getVariants(required - coins[i],
                    removeElement(coins, i),
                    addElement(variants, coins[i])
            );
        }
    }

    public Set<String> getAnswers() {
        return answers;
    }

    int[] removeElement(int[] a, int index) {
        int[] result = new int[a.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i < index ? a[i] : a[i + 1];
        }
        return result;
    }

    int[] addElement(int[] a, int element) {
        int[] result = new int[a.length + 1];
        System.arraycopy(a, 0, result, 0, a.length);
        result[a.length] = element;
        return result;
    }

    void permutation(int[] destination, int[] source) {
        if (source.length == 0) {
            System.out.println(Arrays.toString(destination));
            return;
        }
        for (int i = 0; i < source.length; i++) {
            permutation(addElement(destination, source[i]), removeElement(source, i));
        }
    }

}

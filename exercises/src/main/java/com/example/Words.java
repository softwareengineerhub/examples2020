package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class Words {

    boolean palindromeCheckLoop(String s) {
        String pure = getPureString(s);
        int middle = pure.length() / 2;
        for (int i = 0; i < middle; i++) {
            if (pure.charAt(i) != pure.charAt(pure.length() - 1 - i)) return false;
        }
        return true;
    }

    boolean checkAnagram(String a, String b) {
        String pureA = getPureString(a);
        String pureB = getPureString(b);
        for (int i = 0; i < pureA.length(); i++) {
            char nextChar = pureA.charAt(i);
            int thisCharIndexInB = pureB.indexOf(nextChar);
            if (thisCharIndexInB == -1) return false;
            else pureB = pureB.replaceFirst(String.valueOf(nextChar), " ");
        }
        return pureB.trim().isEmpty();
    }

    boolean checkAnagramStream(String a, String b) {
        int[] pureA = getPureString(a).chars().sorted().toArray();
        int[] pureB = getPureString(b).chars().sorted().toArray();
        return Arrays.equals(pureA, pureB);
    }

    private String getPureString(String s) {
        return s.replaceAll("[^\\da-zA-Zа-яёА-ЯЁ]", "").toLowerCase();
    }

    public Map.Entry<String, Long> wordCountInFile() throws IOException {
        Path path = Paths.get("e:\\1111\\data.txt");
        Map<String, Long> counters = Files.lines(path)
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Zа-яёА-ЯЁ]", "").toLowerCase().trim())
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return counters.entrySet().stream()
                .sorted(comparingByValue())
                .reduce((a, b) -> b).orElse(null);
    }
}

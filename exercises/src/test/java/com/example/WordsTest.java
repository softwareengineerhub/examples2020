package com.example;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;

public class WordsTest {

    Words words = new Words();

    @Test
    public void palindromeCheckLoop() {
        assertFalse(words.palindromeCheckLoop("test1"));
        assertTrue(words.palindromeCheckLoop("test set"));
        assertTrue(words.palindromeCheckLoop("Он дивен, палиндром — и ни морд, ни лап не видно"));
    }

    @Test
    public void checkAnagram() {
        assertTrue(words.checkAnagram("Лунь", "нуль"));
        assertFalse(words.checkAnagram("Лунь", "нoль"));
        assertTrue(words.checkAnagram("Аз есмь строка, живу я, мерой остр", "За семь морей ростка я вижу рост"));
    }

    @Test
    public void checkAnagramStream() {
        assertTrue(words.checkAnagramStream("Лунь", "нуль"));
        assertFalse(words.checkAnagramStream("Лунь", "нoль"));
        assertTrue(words.checkAnagramStream("Аз есмь строка, живу я, мерой остр", "За семь морей ростка я вижу рост"));
    }

    @Test
    public void wordCountInFile() throws IOException {
        Map.Entry<String, Long> lastEntry = words.wordCountInFile();
        System.out.println(lastEntry);
        assertEquals((long) lastEntry.getValue(), 9);
    }
}
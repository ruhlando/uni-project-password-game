package com.bechtle_dhbw.uniProjectPasswordGame.rules;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
    private final String pattern;
    private final Map<Character, Integer> badCharacterTable;

    // Constructor to initialize the pattern and build the bad character table
    public BoyerMoore(String pattern) {
        this.pattern = pattern;
        this.badCharacterTable = buildBadCharacterTable(pattern);
    }

    // Method to build the bad character table for the pattern
    private Map<Character, Integer> buildBadCharacterTable(String pattern) {
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < pattern.length() - 1; i++) {
            table.put(pattern.charAt(i), pattern.length() - 1 - i);
        }
        return table;
    }

    // Method to search for the pattern in the given text using the Boyer-Moore algorithm
    public int search(String text) {
        int m = pattern.length();
        int n = text.length();
        int skip;

        // Loop through the text to find the pattern
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            // Compare pattern from end to start
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    // Calculate the skip value based on the bad character table
                    skip = Math.max(1, j - badCharacterTable.getOrDefault(text.charAt(i + j), -1));
                    break;
                }
            }
            if (skip == 0) {
                return i; // Pattern found at index i
            }
        }
        return -1; // Pattern not found
    }
}

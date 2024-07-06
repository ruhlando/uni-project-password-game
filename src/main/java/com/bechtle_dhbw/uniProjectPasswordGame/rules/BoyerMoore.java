package com.bechtle_dhbw.uniProjectPasswordGame.rules;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
    private final String pattern;
    private final Map<Character, Integer> badCharacterTable;

    public BoyerMoore(String pattern) {
        this.pattern = pattern;
        this.badCharacterTable = buildBadCharacterTable(pattern);
    }

    private Map<Character, Integer> buildBadCharacterTable(String pattern) {
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < pattern.length() - 1; i++) {
            table.put(pattern.charAt(i), pattern.length() - 1 - i);
        }
        return table;
    }

    public int search(String text) {
        int m = pattern.length();
        int n = text.length();
        int skip;

        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
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

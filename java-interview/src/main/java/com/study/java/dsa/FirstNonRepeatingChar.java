package com.study.java.dsa;

import java.util.LinkedHashMap;
import java.util.Map;
//#5 xample Find the First Non-Repeating Character in a String linkedHashmap provides order and track frequency
public class FirstNonRepeatingChar {
    public static char findFirstNonRepeating(String str) {
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '_'; // Return '_' if no unique character exists
    }

    // ✅ Static method for Main.java
    public static void run() {
        String testStr = "swiss";
        System.out.println("First non-repeating character: " + findFirstNonRepeating(testStr));
    }
}

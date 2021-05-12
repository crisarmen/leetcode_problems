package com.personal.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int maxResult = 0;
        int b,e;
        b = e = 0;

        while(e < s.length()) {
            Character c = s.charAt(e);
            e++;
            Integer charCount = chars.get(c);

            if(charCount == null) {
                chars.put(c, 1);
            } else {
                chars.put(c, charCount + 1);
            }

            if(acceptable(chars)) {
                if(chars.size() > maxResult) {
                    maxResult = chars.size();
                }
            } else {
                //make it acceptable again..
                while(!acceptable(chars)) {
                    c = s.charAt(b);
                    charCount = chars.get(c);
                    if(charCount == 1) {
                        chars.remove(c);
                    } else {
                        chars.put(c, charCount-1);
                    }
                    b++;
                }
            }
        }

        return maxResult;
    }

    private boolean acceptable(Map<Character, Integer> m) {
        for(int i : m.values()) {
            if(i > 1) {
                return false;
            }
        }
        return true;
    }
}

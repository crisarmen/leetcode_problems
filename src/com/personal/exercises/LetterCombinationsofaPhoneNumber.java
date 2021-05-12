package com.personal.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsofaPhoneNumber {

    private static final Map<Integer, List<Character>> digits = digitMap();

    public static void main (String[] args) {
        System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digitsStr) {
        List<String> solutions = Arrays.asList("");

        for(char c : digitsStr.toCharArray()) {
            int d = c - '0';
            List<Character> currList = digits.get(d);
            if(!currList.isEmpty()) {
                List<String> newSol = new ArrayList<>();
                for(int i = 0; i < solutions.size() ; i++) {
                    String currSol = solutions.get(i);
                    for(char c1 : currList) {
                        newSol.add(currSol + c1);
                    }
                }
                solutions = newSol;
            }
        }
        if(digitsStr.equals("")) {
            return Arrays.asList();
        } else {
            return solutions;
        }
    }

    private static Map<Integer, List<Character>> digitMap(){
        Map<Integer, List<Character>> digits = new HashMap<>();
        digits.put(0, Arrays.asList(' '));
        digits.put(1, Arrays.asList());
        digits.put(2, Arrays.asList('a','b','c'));
        digits.put(3, Arrays.asList('d','e','f'));
        digits.put(4, Arrays.asList('g','h','i'));
        digits.put(5, Arrays.asList('j','k','l'));
        digits.put(6, Arrays.asList('m','n','o'));
        digits.put(7, Arrays.asList('p','q','r','s'));
        digits.put(8, Arrays.asList('t','u','v'));
        digits.put(9, Arrays.asList('w','x','y','z'));
        return digits;
    }
}

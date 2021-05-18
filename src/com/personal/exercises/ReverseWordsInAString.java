package com.personal.exercises;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("Alice does not even like bob"));
    }

    public String reverseWords(String s) {
        String t = s.trim().replaceAll("\\s+"," ");
        String[] words = t.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if(i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

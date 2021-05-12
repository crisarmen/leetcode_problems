package com.personal.exercises;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        Stack<Integer> idxSt = new Stack<>();

        int maxLength = 0;
        idxSt.push(-1);

        for(int i=0; i< s.length(); i ++) {
            char c = s.charAt(i);
            if(c == ')') {
                idxSt.pop();
                if(idxSt.isEmpty()) {
                    idxSt.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - idxSt.peek());
                }
            } else {
                idxSt.push(i);
            }
        }


        return maxLength;
    }
}

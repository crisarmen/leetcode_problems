package com.personal.exercises;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {
    private static Map<Integer, Integer> res = new HashMap<>();

    public int numTrees(int n) {
        res.clear();
        return numTreesRec(n);
    }

    public int numTreesRec(int n) {

        Integer result = res.get(n);
        if(result != null) {
            return result;
        } else {
            if(n <= 0) {
                result = 1;
            }else if(n <= 2) {
                result = n;
            } else {
                int s = 0;
                for (int i = 0; i < n; i ++) {
                    s += numTreesRec (i) * numTreesRec(n-1-i);
                }
                result = s;
            }
            res.put(n, result);
            return result;
        }
    }
}

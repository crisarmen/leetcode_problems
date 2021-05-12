package com.personal.exercises;

/**
 * https://leetcode.com/problems/container-with-most-water/submissions/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int b,e;
        b = 0; e = height.length - 1;

        while(b < e) {
            int area = (e - b) * Math.min(height[b], height[e]);
            if(area > max) {
                max = area;
            }

            if(height[b] > height[e]) {
                e--;
            } else {
                b++;
            }
        }
        return max;
    }
}

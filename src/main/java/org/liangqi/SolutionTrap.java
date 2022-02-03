package org.liangqi;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Leedcode https://leetcode.com/problems/trapping-rain-water/solution/ Reference: https://www.geeksforgeeks.org/trapping-rain-water/
 */
public class SolutionTrap {

    public static int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return result;

    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = arr.length;
        System.out.print(trap(arr));
    }
}

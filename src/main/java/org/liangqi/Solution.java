package org.liangqi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Leedcode
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
//        Collections.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]) );
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        new ArrayList<>().toArray();
        List<int[]> a = Arrays.asList(intervals);

        a.forEach((item) -> {
            int ab;
            System.out.println(Arrays.toString(item));
        });
        return intervals;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[][] test = {{1, 2}, {7, 9}, {2, 11}, {5, 9}};
        int[][][] test1 = {{{1}, {2}}, {{7}, {9}}};
        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(so.merge(test)));
    }
}

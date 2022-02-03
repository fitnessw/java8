package org.liangqi;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Leedcode
 * https://leetcode.com/problems/merge-intervals/solution/
 */
public class SolutionMerge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> queue = new LinkedList<>();
        for(int[] interval : intervals){
            if(queue.isEmpty() || queue.getLast()[1] < interval[0] ){
                queue.add( interval );
            }else if( queue.getLast()[1] >= interval[0]){
                queue.getLast()[1] = Math.max(queue.getLast()[1],interval[1]);
            }
        }
        String[] abc = new ArrayList<>().toArray(new String[0]);
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {
        SolutionMerge so = new SolutionMerge();
        int[][] test = {{1, 2}, {7, 9}, {2, 11}, {5, 9}};
//        int[][][] test1 = {{{1}, {2}}, {{7}, {9}}};
        int[] bb= {1,3,4,5};
        List<Integer> ddd = Arrays.stream(bb).boxed().collect(Collectors.toList());
        Integer[] cc = {1,3,4,5};
        List<Integer> rrr = Arrays.asList( cc );
        List<int[]> abccc = Arrays.asList(test);
        abccc.forEach((item)-> System.out.println(Arrays.toString(item)));
        Map<String,Integer> map = new HashMap<>();
        map.put("abc",1);
        map.merge("abc",2, (old,new1) -> old+new1);
        map.forEach((key,value) -> System.out.println("Key:"+ key + "value:"+value));
        map.values().forEach(System.out::println);
        System.out.println(Arrays.deepToString(test));
        System.out.println(Arrays.deepToString(so.merge(test)));

        String[] ad = {"ab","de","ba","33","a3w","3wa","wa3"};
        Arrays.stream(ad).collect(groupingBy(word -> al(word))).values().stream().filter(group -> group.size() >= 2)
                .forEach(g -> System.out.println(g.size() + ":" + g));
    }

    private static String al(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String( chars);
    }
}

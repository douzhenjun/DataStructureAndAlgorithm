package 力扣真题.贪心算法.根据身高重建队列.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> {
            if(x[0] == y[0]){
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(y[0], x[0]);
        });
        LinkedList<int[]> lst = new LinkedList<>();
        for(int[] p : people){
            lst.add(p[1], p);
        }
        return lst.toArray(new int[people.length][]);
        
    }
}

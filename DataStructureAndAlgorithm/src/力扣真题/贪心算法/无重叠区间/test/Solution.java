package 力扣真题.贪心算法.无重叠区间.test;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int func(int[][] intervals){
        int count = 0;
        Arrays.sort(intervals, (x,y)->Integer.compare(x[0],y[0]));
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                count++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);
            }
        }
        return count;
    }
}

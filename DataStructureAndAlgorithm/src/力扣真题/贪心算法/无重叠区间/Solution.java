package 力扣真题.贪心算法.无重叠区间;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                count++;
            } else {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }
        }
        return len - 1 - count;
    }
}

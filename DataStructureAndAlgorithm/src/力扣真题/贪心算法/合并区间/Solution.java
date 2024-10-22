package 力扣真题.贪心算法.合并区间;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if(x[0] == y[0]){
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });
        int len = intervals.length;
        for(int i = 1; i < len; i++){
            if(intervals[i][0] <= intervals[i-1][1]){
                intervals[i][0] = intervals[i-1][0];
                if(intervals[i][1] <= intervals[i-1][1]){
                    intervals[i][1] = intervals[i-1][1];
                }
                intervals[i-1] = new int[0];
            }
        }
        List<int[]> resultList = new LinkedList<>();
        for(int i = 0; i < len; i++){
            if(intervals[i].length > 0){
                resultList.add(intervals[i]);
            }
        }
        return resultList.toArray(new int[resultList.size()][]);
    }
}
